package org.hung.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.availability.LivenessStateHealthIndicator;
import org.springframework.boot.actuate.availability.ReadinessStateHealthIndicator;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HealthCheckConfig {

	@Autowired
	private ApplicationAvailability applicationAvailability;

	@Bean
	ReadinessStateHealthIndicator readinessStateHealthIndicator() {
		ReadinessStateHealthIndicator indicator = new ReadinessStateHealthIndicator(applicationAvailability);
		return indicator;
	}
	
	@Bean
	LivenessStateHealthIndicator livenessStateHealthIndicator() {
		LivenessStateHealthIndicator indicator = new LivenessStateHealthIndicator(applicationAvailability);
		return indicator;
	}
}
