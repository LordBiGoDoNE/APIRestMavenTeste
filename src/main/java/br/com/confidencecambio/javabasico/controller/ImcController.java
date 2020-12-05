package br.com.confidencecambio.javabasico.controller;

import br.com.confidencecambio.javabasico.service.ImcService;
import br.com.confidencecambio.javabasico.vo.Cliente;
import br.com.confidencecambio.javabasico.vo.Gerente;
import br.com.confidencecambio.javabasico.vo.Robo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImcController {

    @Autowired
    private ImcService service;

    @RequestMapping("/imc")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> retornarImc(@RequestBody String json) {
        return service.calcularImc(json);
    }
    
    @RequestMapping("/nomes")
    public String retornarImc() {
        StringBuilder sb = new StringBuilder();
        
        Cliente cliente = new Cliente("Viviane Vieira da Silva");
        Gerente gerente = new Gerente("Richard Meneghelli da Silva");
        Robo robo = new Robo("Rafael Vieira da Silva");
        
        sb.append("CLIENTE").append("<br>")
        .append(cliente.retornaNome(false)).append("<br>")
        .append(cliente.retornaNome(true)).append("<br>")
        .append(cliente.retornaNomeAbreviado(false)).append("<br>")
        .append(cliente.retornaNomeAbreviado(true)).append("<br>")
        .append(cliente.retornaPrimeiroNome(false)).append("<br>")
        .append(cliente.retornaPrimeiroNome(true)).append("<br>")
        .append(cliente.retornaSobrenome(false)).append("<br>")
        .append(cliente.retornaSobrenome(true)).append("<br>");

        sb.append("<br>");
                       
        sb.append("GERENTE").append("<br>")
        .append(gerente.retornaNome(false)).append("<br>")
        .append(gerente.retornaNome(true)).append("<br>")
        .append(gerente.retornaNomeAbreviado(false)).append("<br>")
        .append(gerente.retornaNomeAbreviado(true)).append("<br>")
        .append(gerente.retornaPrimeiroNome(false)).append("<br>")
        .append(gerente.retornaPrimeiroNome(true)).append("<br>")
        .append(gerente.retornaSobrenome(false)).append("<br>")
        .append(gerente.retornaSobrenome(true)).append("<br>");
        
        sb.append("<br>");
        
        sb.append("ROBO").append("<br>")
        .append(robo.retornaNome(false)).append("<br>")
        .append(robo.retornaNome(true)).append("<br>")
        .append(robo.retornaNomeAbreviado(false)).append("<br>")
        .append(robo.retornaNomeAbreviado(true)).append("<br>")
        .append(robo.retornaPrimeiroNome(false)).append("<br>")
        .append(robo.retornaPrimeiroNome(true)).append("<br>")
        .append(robo.retornaSobrenome(false)).append("<br>")
        .append(robo.retornaSobrenome(true));
        
        return sb.toString();
    }
}
