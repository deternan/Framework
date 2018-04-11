
/*
 * https://www.quickprogrammingtips.com/spring-boot/tutorial-spring-boot-application-development-using-sts.html
 * https://blog.csdn.net/spicehava1/article/details/78662157
 */

package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}
