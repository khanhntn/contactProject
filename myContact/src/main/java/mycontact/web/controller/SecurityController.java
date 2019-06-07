package mycontact.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/admin") 
    public String admin() {
        return "admin";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/login") 
    public String getLogin() {
        return "login";
    }
}
