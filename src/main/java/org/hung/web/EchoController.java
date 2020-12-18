package org.hung.web;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	@GetMapping("/chance")
	public ResponseEntity<String> chance() {
		if (Math.random() > 0.3) {
			return ResponseEntity.ok("success");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
		}
	}
	
	@GetMapping("/delay")
	public String delay() {
		long delay = Math.round(Math.random()*1000*3);
		try {
			Thread.currentThread().sleep(delay);
		} catch (InterruptedException e) {
			log.info("wake up");
		}
		return "After " + delay + " ms delay.";
	}
}
