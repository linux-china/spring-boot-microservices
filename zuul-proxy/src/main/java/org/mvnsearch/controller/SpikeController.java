package org.mvnsearch.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spike controller
 *
 * @author linux_china
 */
@RestController
@RequestMapping("/spike")
public class SpikeController {

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
