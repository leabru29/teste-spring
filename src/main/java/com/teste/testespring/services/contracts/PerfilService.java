package com.teste.testespring.services.contracts;

import java.util.List;

import com.teste.testespring.models.Perfil;

public interface PerfilService {
    Perfil createPerfil(Perfil perfil);

    List<Perfil> findAllPerfil();

    Perfil findByIdPerfil(Long id);

    Perfil updatePerfil(Perfil perfil);

    void deletePerfil(Long id);
}
