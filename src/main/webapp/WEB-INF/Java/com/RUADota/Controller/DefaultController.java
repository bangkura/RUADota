package com.RUADota.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {
    @RequestMapping("/")
    public @ResponseBody String welcome() {
        return "welcome to RUADota";
    }
}