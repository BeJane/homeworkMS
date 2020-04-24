package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author:Jingqi Wu
 * @date: 2020/4/15
 */
@Controller
public class TestController {
    @RequestMapping(value = "hello")
    public String student() {

        return "hello";
    }

}
