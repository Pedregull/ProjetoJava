package br.com.recode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	 @GetMapping("/Home")
	    public String Home() {
	        return "Home";
	    }
	 
	 @GetMapping("/Login")
	    public String Login() {
	        return "Login";
	    }
	 @GetMapping("/Cadastro")
	    public String Cadastro() {
	        return "Cadastro";
	    }
	 @GetMapping("/Destinos")
	    public String Destinos() {
	        return "Destinos";
	    }
	 @GetMapping("/Promoções")
	    public String Promoções() {
	        return "Promoções";
	    }
	 @GetMapping("/Contato")
	    public String Contato() {
	        return "Contato";
	    }
}
