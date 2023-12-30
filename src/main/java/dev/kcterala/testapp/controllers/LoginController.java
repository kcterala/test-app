package dev.kcterala.testapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/")
    public ResponseEntity<String> greet() {
        String greetMessage = "Hello Dharani, Thanks for visiting";
        logger.info("Greeting the user");
        return ResponseEntity.ok(greetMessage);
    }
}
