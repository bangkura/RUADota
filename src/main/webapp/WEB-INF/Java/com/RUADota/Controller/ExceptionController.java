package com.RUADota.Controller;

import com.RUADota.Entity.Error;
import com.RUADota.Exception.MatchDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MatchDetailsNotFoundException.class)
    @ResponseBody
    public String matchNotFound(MatchDetailsNotFoundException e) {
        return "You entered the wrong match id, please try again";
    }
}
