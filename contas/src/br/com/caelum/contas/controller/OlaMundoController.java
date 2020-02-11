package br.com.caelum.contas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OlaMundoController {
  @RequestMapping("/olaMundoSpring")
  public String teste() {
    System.out.println("Executando a lógica com Spring MVC");
    return "ok";
  }
}