package org.mvnsearch.app4;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

/**
 * user service implementation
 *
 * @author linux_china
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private CounterService counterService;

    @Override
    @HystrixCommand(fallbackMethod = "nullNick", commandProperties = {@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "20")})
    public String findNick(Integer id) {
        counterService.increment("invoke");
        if (id % 3 == 1) {
            counterService.increment("invoke.error");
            throw new RuntimeException();
        }
        return "nick:" + id;
    }

    public String nullNick(Integer id) {
        counterService.increment("fallback");
        return null;
    }
}
