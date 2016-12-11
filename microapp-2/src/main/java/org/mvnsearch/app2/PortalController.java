package org.mvnsearch.app2;

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
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
    @Autowired
    private CounterService counterService;
    @Autowired
    private MetricRegistry registry;

    @GetMapping("/")
    public String welcome() {
        counterService.increment("counter.page.welcome");
        Counter evictions = registry.counter("dropwizard.page.welcome");
        evictions.inc(2);
        return "hello" + nick;
    }
}
