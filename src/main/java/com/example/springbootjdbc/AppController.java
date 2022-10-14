package com.example.springbootjdbc;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class AppController {
    private final ProductRepository repository;

    @GetMapping("/products/fetch-product")
    public String getProductName(@RequestParam String name) {
        return String.valueOf(repository.getProductNames(name));
    }
}