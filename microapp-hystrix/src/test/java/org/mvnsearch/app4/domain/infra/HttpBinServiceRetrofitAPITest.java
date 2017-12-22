package org.mvnsearch.app4.domain.infra;

import org.junit.Test;
import org.mvnsearch.app4.HystrixApplicationBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Response;

/**
 * http bin retrofit api test
 *
 * @author linux_china
 */
public class HttpBinServiceRetrofitAPITest extends HystrixApplicationBaseTest {

    @Autowired
    private HttpBinServiceRetrofitAPI httpBinServiceRetrofitAPI;

    @Test
    public void testIp() throws Exception {
        Response<HttpBinResponse> response = httpBinServiceRetrofitAPI.ip().execute();
        if (response.isSuccessful()) {
            System.out.println(response.body().getOrigin());
        }
    }

    @Test
    public void testHeaders() throws Exception {
        Response<HttpBinResponse> response = httpBinServiceRetrofitAPI.headers().execute();
        if (response.isSuccessful()) {
            System.out.println(response.body().getHeaders());
        }
    }
}
