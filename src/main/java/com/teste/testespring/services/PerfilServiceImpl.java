package com.teste.testespring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.testespring.models.Perfil;
import com.teste.testespring.repositories.PerfilRepository;
import com.teste.testespring.services.contracts.PerfilService;

import jakarta.transaction.Transactional;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Transactional
    public Perfil createPerfil(Perfil perfil) {
        perfil.setId(null);
        return perfilRepository.save(perfil);
    }

    @Override
    public List<Perfil> findAllPerfil() {
        return perfilRepository.findAll();
    }

    @Override
    public Perfil findByIdPerfil(Long id) {
        Optional<Perfil> perfil = perfilRepository.findById(id);
        return perfil.orElseThrow(() -> new RuntimeException("Perfil não encontrado."));
    }

    @Transactional
    public Perfil updatePerfil(Perfil perfil) {
        Perfil existePerfil = perfilRepository.findById(perfil.getId())
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado."));
        existePerfil.setNome_perfil(perfil.getNome_perfil());
        existePerfil.setAtivo(perfil.getAtivo());
        Perfil updatePerfil = perfilRepository.save(existePerfil);
        return updatePerfil;

    }

    @Override
    public void deletePerfil(Long id) {
        findByIdPerfil(id);
        try {
            perfilRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Não foi possível deletar o Perfil pois o mesmo está vinculado a algum usuário.");
        }
    }

}
