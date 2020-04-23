package Martins.Guilherme.bancoH2Database.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String index(){return "Seja muito bem vindo ao sitema!";}
}