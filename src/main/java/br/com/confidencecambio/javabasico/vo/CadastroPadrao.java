package br.com.confidencecambio.javabasico.vo;

import java.util.Objects;

public class CadastroPadrao {

    private String nome = "";

    public CadastroPadrao(String nome) {
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        checkVazioNulo(nome);
        this.nome = nome;
    }

    public String retornaNome(boolean upperCase) {
        if (upperCase) {
            return getNome().toUpperCase();
        }
        
        return getNome();
    }
    
    public String retornaNomeAbreviado(boolean upperCase) {
        String nomeSplited[] = getNome().split("\\s+");
        
        for (int i = 0; i < nomeSplited.length; i++) {
            if(i == 0 || i+1 == nomeSplited.length || nomeSplited[i].length() <= 2){
                continue;
            }
            
            nomeSplited[i] = nomeSplited[i].substring(0, 1) + ".";
        }
        
        String retorno = String.join(" ", nomeSplited);
        
        if (upperCase) {
            return retorno.toUpperCase();
        }
        
        return retorno;
    }
    
    public String retornaPrimeiroNome(boolean upperCase) {
        String nomeSplited[] = getNome().split("\\s+");
        
        if (upperCase) {
            return nomeSplited[0].toUpperCase();
        }
        
        return nomeSplited[0];
    }
    
    public String retornaSobrenome(boolean upperCase) {
        String nomeSplited[] = getNome().split("\\s+");
        String arraySobrenome[] = new String[nomeSplited.length -1];
        
        for (int i = 0; i < arraySobrenome.length; i++) {
            arraySobrenome[i] = nomeSplited[i+1];
        }
        
        String retorno = String.join(" ", arraySobrenome);
        
        if (upperCase) {
            return retorno.toUpperCase();
        }
        
        return retorno;
    }
    
    private void checkVazioNulo(String nome) {
        Objects.requireNonNull(nome, "Campo não pode ser nulo");
         
        if(nome.isBlank()){
            throw new IllegalArgumentException("Campo não pode ser vazio");
        }
    }
}
