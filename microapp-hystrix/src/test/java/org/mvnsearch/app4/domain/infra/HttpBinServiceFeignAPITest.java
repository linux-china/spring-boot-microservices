package org.mvnsearch.app4.domain.infra;

import org.junit.Test;
import org.mvnsearch.app4.HystrixApplicationBaseTest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * httpbin service feign api test
 *
 * @author linux_china
 */
public class HttpBinServiceFeignAPITest extends HystrixApplicationBaseTest {
    @Autowired
    private HttpBinServiceFeignAPI feignAPI;

    @Test
    public void testIp() {
        System.out.println(feignAPI.ip().getIp());
    }
}
