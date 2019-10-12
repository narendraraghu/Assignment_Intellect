package com.candidate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
class HealthcheckController {

    @GetMapping(value = "/healthcheck")
    public String healthcheck() {
        return "OK";
    }

    @GetMapping(value = "/healthcheck", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> healthcheckPut(@RequestParam String format) {

        if ("full".equals(format)) {
            return new ResponseEntity<>(String.valueOf(System.currentTimeMillis()), HttpStatus.OK);
        }
        if ("short".equals(format)) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/healthcheck")
    public HttpStatus healthcheckPost() {
        return HttpStatus.BAD_REQUEST;
    }


    @DeleteMapping(value = "/healthcheck")
    public void healthcheckDelete() {
        return;
    }

}
