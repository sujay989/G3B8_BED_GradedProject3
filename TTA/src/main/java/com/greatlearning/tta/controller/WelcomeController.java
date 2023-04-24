package com.greatlearning.tta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping("/welcome")
	public String handleWelcomePage() {
		return "welcome";
	}
}
