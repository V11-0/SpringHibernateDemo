package com.vinibrenobr11.springhibernatedemo.apis;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hello", produces = { MediaType.APPLICATION_JSON_VALUE })
public class DemoApi {

    @GetMapping
    public String teste() {
        return "{\"Message\": \"Hello, World\"}";
    }
}
