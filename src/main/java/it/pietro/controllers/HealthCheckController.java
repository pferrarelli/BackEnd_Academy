package it.pietro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

	@GetMapping("/check")
    public String Healthcheck() {
        System.out.println("HEALTH_CHECK DONE!");
        return "OK";
    }
}
