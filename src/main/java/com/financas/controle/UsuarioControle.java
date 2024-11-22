package com.financas.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.service.UsuarioService;

@RestController
@RequestMapping("api/cadastroUsuario")
public class UsuarioControle {
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping
    public ResponseEntity<String> salvar (@RequestBody String dadosCadastroUsuario){
        usuarioService.salvar(dadosCadastroUsuario);
        return ResponseEntity.ok(dadosCadastroUsuario);

    }

    
}
