package kr.cloud.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyViewController {

    @GetMapping("/")
    public String goLogin() {
        return "login";
    }
}
