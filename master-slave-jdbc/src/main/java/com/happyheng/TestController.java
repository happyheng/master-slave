package com.happyheng;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by happyheng on 17/1/4.
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
