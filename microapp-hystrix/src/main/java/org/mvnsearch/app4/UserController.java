package org.mvnsearch.app4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * user controller
 *
 * @author linux_china
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public String welcome(@PathVariable Integer id) {
        return userService.findNick(id);
    }
    
}
