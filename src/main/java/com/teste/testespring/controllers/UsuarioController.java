package com.teste.testespring.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.testespring.models.Usuario;
import com.teste.testespring.services.UsuarioServiceImpl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario saveUsuario = usuarioServiceImpl.createUsuario(usuario);
        return new ResponseEntity<>(saveUsuario, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findUsuario(@PathVariable("id") UUID id) {
        Usuario usuario = usuarioServiceImpl.getUsuario(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = usuarioServiceImpl.listUsuarios();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") UUID id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        Usuario updateUsuario = usuarioServiceImpl.updateUsuario(usuario);
        return new ResponseEntity<>(updateUsuario, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") UUID id) {
        usuarioServiceImpl.deleteUsuario(id);
        return new ResponseEntity<>("Usuario deletado com sucesso!", HttpStatus.OK);
    }
}
