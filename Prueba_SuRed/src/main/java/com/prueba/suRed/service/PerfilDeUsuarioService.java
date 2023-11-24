package com.prueba.suRed.service;

import com.prueba.suRed.entity.PerfilDeUsuario;
import com.prueba.suRed.repository.PerfilDeUsurioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilDeUsuarioService {

    @Autowired
    private  PerfilDeUsurioRepository repository;


    public PerfilDeUsuario guardarPerfil(PerfilDeUsuario perfilDeUsuario) {
        return repository.save(perfilDeUsuario);
    }

    public Optional<PerfilDeUsuario> findById(Long id){
        return repository.findById(id);
    }

    public List<PerfilDeUsuario> findAll(){
        return repository.findAll();
    }

    public Optional<PerfilDeUsuario> finById(Long id) {
        return repository.findById(id);
    }

    public void save(PerfilDeUsuario perfilDeUsuario) {
         repository.save(perfilDeUsuario);
    }
}
