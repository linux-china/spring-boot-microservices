package org.mvnsearch.boot;

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
    @Value("${company}")
    private String company;

    @GetMapping("/")
    public String index() {
        return company;
    }
}
