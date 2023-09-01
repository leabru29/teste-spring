package com.teste.testespring.services.contracts;

import java.util.UUID;
import java.util.List;
import com.teste.testespring.models.Usuario;

public interface UsuarioService {
    Usuario createUsuario(Usuario usuario);

    Usuario findByIdUsuario(UUID id);

    List<Usuario> listUsuarios();

    Usuario updateUsuario(Usuario usuario);

    void deleteUsuario(UUID id);
}
