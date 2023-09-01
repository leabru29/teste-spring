package com.teste.testespring.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", length = 60, nullable = false)
    @NotBlank(message = "Por favor preencha o campo Nome")
    @Size(min = 3, max = 60, message = "O campo Nome precisa de no mínimo 3 caracteres e no máximo 60 caracteres.")
    private String nome;

    @Column(name = "sobrenome", length = 100, nullable = false)
    @NotBlank(message = "Por favor preencha o campo Sobrenome")
    @Size(min = 3, max = 100, message = "O campo Sobrenome precisa de no mínimo 3 caracteres e no máximo 100 caracteres.")
    private String sobrenome;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    @NotBlank(message = "Por favor preencha o campo E-mail")
    @Size(min = 3, max = 100, message = "O campo E-mail precisa de no mínimo 3 caracteres e no máximo 60 caracteres.")
    private String email;

    @Column(name = "passwd", nullable = false)
    @NotBlank(message = "Por favor preencha o campo Senha")
    private String senha;

    @ManyToOne
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil;
}
