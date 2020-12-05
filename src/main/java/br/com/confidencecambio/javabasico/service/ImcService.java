package br.com.confidencecambio.javabasico.service;

import br.com.confidencecambio.javabasico.vo.Imc;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.springframework.stereotype.Component;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Component
public class ImcService {

    public ResponseEntity<String> calcularImc(String json) {

        StringBuilder retorno = new StringBuilder();

        Imc imc;

        try {
            imc = new Gson().fromJson(json, Imc.class);
        } catch (JsonSyntaxException ex) {
            retorno.append("Json invalido.").append("\nJson enviado:").append(json);
            return new ResponseEntity<>(retorno.toString(), HttpStatus.BAD_REQUEST);
        }

        if (imc.getAltura() <= 0 || imc.getPeso() <= 0) {
            retorno.append("Altura e/ou Peso devem ser maiores que 0.")
                    .append("\nAltura: ").append(imc.getAltura()).append(" Peso: ").append(imc.getPeso())
                    .append("\nJson enviado:").append(json);
            return new ResponseEntity<>(retorno.toString(), HttpStatus.BAD_REQUEST);

        }

        double calculoImc = imc.getPeso() / (imc.getAltura() * imc.getAltura());

        retorno.append("Imc de :").append(calculoImc);

        if (calculoImc <= 18.5) {
            retorno.append(" - Abaixo do Peso Ideal.");
        } else if (calculoImc >= 18.5 && calculoImc < 25) {
            retorno.append(" - Está no Peso Ideal.");
        } else if (calculoImc >= 25 && calculoImc < 30) {
            retorno.append(" - Está com Sobrepeso.");
        } else if (calculoImc >= 30) {
            retorno.append(" - Está Obeso.");
        }

        return new ResponseEntity<>(retorno.toString(), HttpStatus.OK);
    }
}
