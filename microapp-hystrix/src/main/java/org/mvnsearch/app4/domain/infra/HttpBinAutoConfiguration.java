package org.mvnsearch.app4.domain.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.HystrixCommand;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Target;
import feign.hystrix.HystrixFeign;
import feign.hystrix.SetterFactory;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import okhttp3.OkHttpClient;
import org.mvnsearch.app4.domain.infra.retrofit.HystrixCallAdapterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.lang.reflect.Method;

/**
 * httpbin auto configuration
 *
 * @author linux_china
 */
@Configuration
public class HttpBinAutoConfiguration {

    @Bean
    public HttpBinServiceRetrofitAPI httpBinServiceRetrofitAPI(ObjectMapper objectMapper) {
        return new Retrofit.Builder().
                baseUrl("http://httpbin.org").
                client(okHttpClient()).
                addCallAdapterFactory(new HystrixCallAdapterFactory("HttpBinServiceRetrofitAPI")).
                addConverterFactory(JacksonConverterFactory.create(objectMapper)).
                build().
                create(HttpBinServiceRetrofitAPI.class);
    }

    @Bean
    public HttpBinServiceFeignAPI httpBinServiceFeignAPI(ObjectMapper objectMapper, OkHttpClient okHttpClient) {
        return HystrixFeign.builder()
                .client(new feign.okhttp.OkHttpClient(okHttpClient))
                .logger(new Slf4jLogger())
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(HttpBinServiceFeignAPI.class, "http://httpbin.org");
    }

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder().build();
    }
}
