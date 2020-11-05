package com.example.thymeleafExample.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class AuthorizationController {
	
    @GetMapping()
    public String home() {
        return ("<h1>/ reached</h1>");
    }
    
    @GetMapping("/admin")
    public String admin() {
        return ("<h1>admin reached</h1>");
    }
    
    @GetMapping("/customer")
    public String customer() {
        return ("<h1>customer reached</h1>");
    }
    
    @GetMapping("/tleaf")
    public String tl(Model model) {
    	model.addAttribute("theDate", new java.util.Date());
        return "tleaf.html";
    }
    
//    @GetMapping("/hello")
//	public String sayHello(Model theModel) {
//		theModel.addAttribute("theDate", new java.util.Date());
//		return "helloworld";
//	}
    
    @GetMapping("/user")
    public String user() {
        return ("<h1>user reached</h1>");
    }

}
