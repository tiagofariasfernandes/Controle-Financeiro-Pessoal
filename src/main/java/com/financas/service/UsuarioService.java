package com.financas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.financas.dto.UsuarioDto;
import com.financas.entity.UsuarioEntity;
import com.financas.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método que recebe o UsuarioDto diretamente
    public void salvar(UsuarioDto usuarioDto) {
        // Validação dos dados antes de salvar no banco
        if (usuarioDto.getNomeUsuario() == null || usuarioDto.getNomeUsuario().isEmpty()) {
            throw new IllegalArgumentException("O nome do usuário é obrigatório.");
        }
        if (usuarioDto.getSenhaUsuario() == null || usuarioDto.getSenhaUsuario().isEmpty()) {
            throw new IllegalArgumentException("A senha do usuário é obrigatória.");
        }

        // Conversão do DTO para a entidade de banco de dados
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        
        // Se o ID já existir (edição), preenche o ID da entidade
        if (usuarioDto.getId() != null) {
            usuarioEntity.setId(usuarioDto.getId());
        }
        
        usuarioEntity.setNomeUsuario(usuarioDto.getNomeUsuario());
        usuarioEntity.setSenhaUsuario(usuarioDto.getSenhaUsuario());

        // Salvando no banco de dados
        usuarioRepository.save(usuarioEntity);
    }
}

