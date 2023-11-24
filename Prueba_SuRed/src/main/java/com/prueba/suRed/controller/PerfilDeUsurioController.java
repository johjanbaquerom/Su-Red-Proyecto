package com.prueba.suRed.controller;

import com.prueba.suRed.entity.PerfilDeUsuario;
import com.prueba.suRed.service.PerfilDeUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/perfil")
public class PerfilDeUsurioController {

    @Autowired
    private PerfilDeUsuarioService perfilDeUsuarioService;

    @GetMapping("/consultar")
    public ResponseEntity<?> consultarTodos() {

        List<PerfilDeUsuario> perfilDeUsuarios = perfilDeUsuarioService.findAll();

        return ResponseEntity.ok(perfilDeUsuarios);
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<?> consultarPorId(@PathVariable Long id) {

        Optional<PerfilDeUsuario> usuario = perfilDeUsuarioService.finById(id);

        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearPerfil(@RequestBody PerfilDeUsuario perfilDeUsuario) {

        PerfilDeUsuario perfilGuardado = perfilDeUsuarioService.guardarPerfil(perfilDeUsuario);

        if(perfilDeUsuario.getNombre().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        perfilDeUsuarioService.save(perfilDeUsuario);

        return ResponseEntity.ok(perfilGuardado);
    }

    @PutMapping("/actualisar/{id}")
    public ResponseEntity<?> actualizarPerfil(@PathVariable Long id, @RequestBody PerfilDeUsuario perfilDeUsuario) {

        Optional<PerfilDeUsuario> perfilActualizado = perfilDeUsuarioService.finById(id);

        if(perfilActualizado.isPresent()) {
            PerfilDeUsuario perfil= perfilActualizado.get();
            perfil.setNombre(perfilDeUsuario.getNombre());
            perfil.setApellidos(perfilDeUsuario.getApellidos());
            perfil.setEmail(perfilDeUsuario.getEmail());
            perfil.setTelefono(perfilDeUsuario.getTelefono());
            perfil.setCiudad(perfilDeUsuario.getCiudad());
            perfil.setPais(perfilDeUsuario.getPais());
            perfilDeUsuarioService.save(perfil);

            return ResponseEntity.ok("Servicio actualizado");

        }
        return ResponseEntity.ok(perfilActualizado.get());
    }
}
