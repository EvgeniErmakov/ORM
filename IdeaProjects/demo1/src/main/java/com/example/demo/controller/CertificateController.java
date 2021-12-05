package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/certificates")
@AllArgsConstructor
@Validated
public class CertificateController {

    @GetMapping(value = "/{id}")
    public void findById() {
        System.out.println("lolz");
    }
}
