package org.hung.web;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
	
	@GetMapping("/greeting")
	public String greeting(Principal princpal) {
		return "Hello " + princpal.getName();
	}
}
