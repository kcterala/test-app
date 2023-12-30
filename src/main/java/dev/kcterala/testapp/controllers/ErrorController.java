package dev.kcterala.testapp.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/error")
public class ErrorController extends AbstractErrorController {


    public ErrorController(final ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping
    public ResponseEntity<String> error(HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.FOUND).body("Uh-oh! Page not found");
    }
}
