package com.teste.testespring.models;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
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
public class Usuario implements UserDetails {

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
    @Email(message = "Por favor, preencha um E-mail válido.")
    @NotBlank(message = "Por favor preencha o campo E-mail")
    @Size(min = 3, max = 100, message = "O campo E-mail precisa de no mínimo 3 caracteres e no máximo 60 caracteres.")
    private String email;

    @Column(name = "passwd", nullable = false)
    @NotBlank(message = "Por favor preencha o campo Senha")
    private String senha;

    @ManyToOne
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil;

    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }

        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
