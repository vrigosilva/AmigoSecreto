package br.com.fiap.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public String loginPage(String error, String logout) {
        return "login";
    }
	
	
} 