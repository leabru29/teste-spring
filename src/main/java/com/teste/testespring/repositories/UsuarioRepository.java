package com.teste.testespring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.testespring.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

}
