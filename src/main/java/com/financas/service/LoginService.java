package com.financas.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.financas.dto.LoginDto;
import com.financas.repository.UsuarioRepository;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Boolean logar (LoginDto loginDto){
        if (loginDto == null || loginDto.getNome() == null || loginDto.getSenha() == null){
            throw new IllegalArgumentException("Os dados de login são inválidos ");
        }

        return usuarioRepository.existsByNomeUsuarioAndSenhaUsuario(
            loginDto.getNome(),
            loginDto.getSenha());
            
        
    }
    
    

   

}
