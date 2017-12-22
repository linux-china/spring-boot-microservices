package org.mvnsearch.app4.domain.infra;

import com.netflix.hystrix.HystrixCommand;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * httpbin service retrofit API
 *
 * @author linux_china
 */
public interface HttpBinServiceRetrofitAPI {
    
    @GET("/ip")
    HystrixCommand<Response<HttpBinResponse>> ip();

    @GET("/uuid")
    Response<HttpBinResponse> uuid();

    @GET("/headers")
    Call<HttpBinResponse> headers();
}
