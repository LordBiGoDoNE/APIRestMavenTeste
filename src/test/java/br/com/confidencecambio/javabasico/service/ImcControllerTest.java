package br.com.confidencecambio.javabasico.service;

import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import org.springframework.http.HttpStatus;

public class ImcControllerTest {

    private ImcService service;

    @Before
    public void init() {
        service = new ImcService();
    }

    @Test
    public void passarImcValido() {
        String json = "{\"altura\":1.75,\"peso\":120}";
        assertThat(service.calcularImc(json).getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void passarImcInvalido() {
        String json = "{\"altura\":0,\"peso\":120}";
        assertThat(service.calcularImc(json).getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    }
    
    @Test
    public void passarJsonInvalido() {
        String json = "{\"altura\":,\"peso\":}";
        assertThat(service.calcularImc(json).getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    }
    
}
