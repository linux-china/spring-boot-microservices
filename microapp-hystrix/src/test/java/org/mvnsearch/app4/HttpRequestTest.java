package org.mvnsearch.app4;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

/**
 * http request test
 *
 * @author linux_china
 */
public class HttpRequestTest {

    @Test
    public void testGet() throws Exception {
        OkHttpClient okHttpClient = new OkHttpClient();
        for (int i = 0; i < 1000; i++) {
            Request request = new Request.Builder()
                    .url("http://localhost:8080/user/" + i % 2)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            Thread.sleep(50);
        }
    }
}
