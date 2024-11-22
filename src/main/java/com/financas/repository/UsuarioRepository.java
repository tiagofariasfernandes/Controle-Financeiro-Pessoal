package com.financas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financas.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository <UsuarioEntity, Long> {

    boolean existsByNomeUsuarioAndSenhaUsuario(String nome, String senha);
    
}
