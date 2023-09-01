package com.teste.testespring.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.testespring.models.Usuario;
import com.teste.testespring.repositories.UsuarioRepository;
import com.teste.testespring.services.contracts.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUsuario(UUID id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.get();
    }

    @Override
    public List<Usuario> listUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Usuario existeUsuario = usuarioRepository.findById(usuario.getId()).get();
        existeUsuario.setNome(usuario.getNome());
        existeUsuario.setSobrenome(usuario.getSobrenome());
        existeUsuario.setEmail(usuario.getEmail());
        existeUsuario.setSenha(usuario.getSenha());
        Usuario updateUsuario = usuarioRepository.save(existeUsuario);
        return updateUsuario;
    }

    @Override
    public void deleteUsuario(UUID id) {
        usuarioRepository.deleteById(id);
    }
}
