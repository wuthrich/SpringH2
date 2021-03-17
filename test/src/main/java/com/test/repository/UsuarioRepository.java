package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}