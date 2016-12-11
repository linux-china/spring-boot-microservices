package com.qishon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * portal controller
 *
 * @author linux_china
 */
@RestController
@RefreshScope
public class PortalController {
    @Value("${developer}")
    private String nick;

    @GetMapping("/")
    public String welcome() {
        return "hello" + nick;
    }
}
