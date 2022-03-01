package com.avangenio.firstex.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorRestController {
    
    @RequestMapping("/error")
    public String handleError() {
        
        return "Please check your url";
    }
}
