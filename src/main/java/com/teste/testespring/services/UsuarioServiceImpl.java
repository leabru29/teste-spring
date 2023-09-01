package com.teste.testespring.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teste.testespring.models.Perfil;
import com.teste.testespring.models.Usuario;
import com.teste.testespring.repositories.UsuarioRepository;
import com.teste.testespring.services.contracts.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilServiceImpl perfilServiceImpl;

    @Transactional
    public Usuario createUsuario(Usuario usuario) {
        Perfil perfil = perfilServiceImpl.findByIdPerfil(usuario.getPerfil().getId());
        usuario.setId(null);
        usuario.setPerfil(perfil);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findByIdUsuario(UUID id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
    }

    @Override
    public List<Usuario> listUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Usuario existeUsuario = findByIdUsuario(usuario.getId());
        Perfil perfil = perfilServiceImpl.findByIdPerfil(usuario.getPerfil().getId());
        existeUsuario.setNome(usuario.getNome());
        existeUsuario.setSobrenome(usuario.getSobrenome());
        existeUsuario.setEmail(usuario.getEmail());
        existeUsuario.setSenha(usuario.getSenha());
        existeUsuario.setPerfil(perfil);
        Usuario updateUsuario = usuarioRepository.save(existeUsuario);
        return updateUsuario;
    }

    @Override
    public void deleteUsuario(UUID id) {
        findByIdUsuario(id);
        try {
            this.usuarioRepository.deleteById(id);
        } catch (Exception e) {
            new RuntimeException("Não é possível excluir o Usuário.");
        }
    }
}
