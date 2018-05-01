package com.RUADota.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("error")
public class ErrorController{
    @RequestMapping("400")
    @ResponseBody
    public String handle1(HttpServletRequest request){
        return "400";
    }
    @RequestMapping("404")
    @ResponseBody
    public String handle2(HttpServletRequest request){
        return "404";
    }
    @RequestMapping("500")
    @ResponseBody
    public String handle3(HttpServletRequest request){
        return "500";
    }

}
