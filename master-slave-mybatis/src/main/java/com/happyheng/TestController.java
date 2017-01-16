package com.happyheng;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * test
 * Created by happyheng on 17/1/10.
 */
@RestController
public class TestController {



    @RequestMapping("/test")
    public String test() {
        return "test";
    }

}
