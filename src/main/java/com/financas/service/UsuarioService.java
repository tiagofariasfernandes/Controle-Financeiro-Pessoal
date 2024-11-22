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

    public void salvar (String dadosCadastroUsuario) {
        UsuarioDto usuarioDto = new Gson().fromJson(dadosCadastroUsuario, UsuarioDto.class);

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        if(usuarioDto.getId()!=null){
            usuarioEntity.setId(usuarioDto.getId());

        }

        usuarioEntity.setNomeUsuario(usuarioDto.getNomeUsuario());
        usuarioEntity.setSenhaUsuario(usuarioDto.getSenhaUsuario());
        usuarioRepository.save(usuarioEntity);


    }
    
}
