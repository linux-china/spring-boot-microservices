package org.mvnsearch.app4.domain.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.mvnsearch.app4.domain.infra.retrofit.HystrixCallAdapterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

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
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder().build();
    }
}
