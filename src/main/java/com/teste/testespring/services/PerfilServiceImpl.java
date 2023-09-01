package com.teste.testespring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.testespring.models.Perfil;
import com.teste.testespring.repositories.PerfilRepository;
import com.teste.testespring.services.contracts.PerfilService;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public Perfil createPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public List<Perfil> findAllPerfil() {
        return perfilRepository.findAll();
    }

    @Override
    public Perfil findByIdPerfil(Long id) {
        Optional<Perfil> perfil = perfilRepository.findById(id);
        return perfil.get();
    }

    @Override
    public Perfil updatePerfil(Perfil perfil) {
        Perfil existePerfil = perfilRepository.findById(perfil.getId()).get();
        existePerfil.setNome_perfil(perfil.getNome_perfil());
        existePerfil.setAtivo(perfil.getAtivo());
        Perfil updatePerfil = perfilRepository.save(existePerfil);
        return updatePerfil;

    }

    @Override
    public void deletePerfil(Long id) {
        perfilRepository.deleteById(id);
    }

}
