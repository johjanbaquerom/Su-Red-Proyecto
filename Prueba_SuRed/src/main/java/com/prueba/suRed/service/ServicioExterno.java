package com.prueba.suRed.service;


import com.prueba.suRed.entity.PerfilDeUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class ServicioExterno {

    private final RestTemplate restTemplate;

    @Autowired
    public ServicioExterno(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void consumirServicio(PerfilDeUsuario perfilDeUsuario) {
        String url = "http://localhost:8080/perfil/crear";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PerfilDeUsuario> requestEntity = new HttpEntity(perfilDeUsuario, headers);

        restTemplate.postForObject(url, requestEntity, PerfilDeUsuario.class);
    }
}

