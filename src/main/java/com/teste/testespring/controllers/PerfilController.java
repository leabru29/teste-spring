package com.teste.testespring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.testespring.models.Perfil;
import com.teste.testespring.services.PerfilServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilController {

    @Autowired
    private PerfilServiceImpl perfilServiceImpl;

    @PostMapping
    public ResponseEntity<Perfil> createPerfil(@Valid @RequestBody Perfil perfil) {
        Perfil novoPerfil = perfilServiceImpl.createPerfil(perfil);
        return new ResponseEntity<>(novoPerfil, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Perfil>> listPerfil() {
        List<Perfil> perfil = perfilServiceImpl.findAllPerfil();
        return new ResponseEntity<>(perfil, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Perfil> getPerfil(@PathVariable Long id) {
        Perfil perfil = perfilServiceImpl.findByIdPerfil(id);
        return ResponseEntity.ok().body(perfil);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Perfil> updatePerfil(@PathVariable Long id, @RequestBody Perfil perfil) {
        perfil.setId(id);
        Perfil perfilAtualizado = perfilServiceImpl.updatePerfil(perfil);
        return new ResponseEntity<>(perfilAtualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public String deletePerfil(@PathVariable Long id) {
        perfilServiceImpl.deletePerfil(id);
        return "Perfil deletado com sucesso!";
    }
}
