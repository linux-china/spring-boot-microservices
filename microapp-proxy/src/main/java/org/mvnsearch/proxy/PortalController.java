package org.mvnsearch.proxy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * portal controller
 *
 * @author linux_china
 */
@RestController
public class PortalController {


    @GetMapping("/")
    public String index() {
        return "hello jackie";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/demo/welcome")
    public String welcome2() {
        return "welcome2";
    }
}
