package org.mvnsearch.app4;

import org.mvnsearch.app4.domain.infra.HttpBinResponse;
import org.mvnsearch.app4.domain.infra.HttpBinServiceRetrofitAPI;
import org.mvnsearch.app4.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;

import java.io.IOException;

/**
 * user controller
 *
 * @author linux_china
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpBinServiceRetrofitAPI retrofitAPI;

    @GetMapping("/user/{id}")
    public String welcome(@PathVariable Integer id) {
        return userService.findNick(id);
    }

    @GetMapping("/ip")
    public String ip() throws IOException {
        Response<HttpBinResponse> response = retrofitAPI.ip().execute();
        return response.body().getIp();
    }

    @GetMapping("/uuid")
    public String uuid() throws IOException {
        Response<HttpBinResponse> response = retrofitAPI.uuid();
        return response.body().getUuid();
    }

}
