package org.mvnsearch.app4.domain.infra.retrofit;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.ReflectionUtils;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * hystrix call adapter
 *
 * @author baitouweng
 */
public class HystrixCallAdapter<R> implements CallAdapter<R, Object> {

    private final boolean isHystrixCommand;

    private final boolean isObservable;

    private final boolean isSingle;

    private final boolean isCompletable;

    private final boolean isBody;

    private final boolean isResponse;

    private final Type responseType;

    private final String commandGroup;

    private static Field serviceMethodField;
    private static Field relativeUrlField;

    public HystrixCallAdapter(Type responseType, boolean isResponse, boolean isBody,
                              boolean isHystrixCommand, boolean isObservable, boolean isSingle,
                              boolean isCompletable, String commandGroup) {
        this.responseType = responseType;
        this.isResponse = isResponse;
        this.isBody = isBody;
        this.isHystrixCommand = isHystrixCommand;
        this.isObservable = isObservable;
        this.isSingle = isSingle;
        this.isCompletable = isCompletable;
        this.commandGroup = commandGroup;
    }

    static {
        try {
            Class<?> okHttpCallClass = Class.forName("retrofit2.OkHttpCall");
            Class<?> serviceMethodClass = Class.forName("retrofit2.ServiceMethod");
            serviceMethodField = ReflectionUtils.findField(okHttpCallClass, "serviceMethod");
            serviceMethodField.setAccessible(true);
            relativeUrlField = ReflectionUtils.findField(serviceMethodClass, "relativeUrl");
            relativeUrlField.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public Object adapt(@NotNull Call<R> call) {
        HystrixCommand.Setter setter = obtainHystrixCommandSetter(call);

        HystrixCommand hystrixCommand = new HystrixCommand(setter) {
            @Override
            protected Object run() throws Exception {
                try {
                    Response<R> response = call.execute();
                    if (HystrixCallAdapter.this.isBody) {
                        return response.body();
                    }
                    return response;
                } catch (Exception e) {
                    //Do not trigger circuitBreaker
                    throw new HystrixBadRequestException(e.getMessage(), e.getCause());
                }
            }
        };

        if (isHystrixCommand) {
            return hystrixCommand;
        }

        if (isObservable) {
            // cold Observable
            return hystrixCommand.toObservable();
        }

        if (isSingle) {
            return hystrixCommand.toObservable().toSingle();
        }

        if (isCompletable) {
            return hystrixCommand.toObservable().toCompletable();
        }

        return hystrixCommand.execute();
    }

    private HystrixCommand.Setter obtainHystrixCommandSetter(Call<R> call) {
        String method = call.request().method();
        Object serviceMethod = ReflectionUtils.getField(serviceMethodField, call);
        String relativeUrl = (String) ReflectionUtils.getField(relativeUrlField, serviceMethod);
        String commandKey = method + "#" + relativeUrl;
        return HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey(this.commandGroup))
                .andCommandKey(HystrixCommandKey.Factory.asKey(commandKey));
    }
}