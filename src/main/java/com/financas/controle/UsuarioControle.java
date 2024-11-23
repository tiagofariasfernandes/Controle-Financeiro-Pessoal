package com.financas.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.dto.UsuarioDto;
import com.financas.service.UsuarioService;

@RestController
@RequestMapping("api/cadastroUsuario")
public class UsuarioControle {
    
    @Autowired
    private UsuarioService usuarioService;

    // Método POST para cadastrar usuário
    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody UsuarioDto usuarioDto) {
        try {
            // Chama o serviço para salvar o usuário
            usuarioService.salvar(usuarioDto);
            
            // Retorno de sucesso com mensagem
            return ResponseEntity.ok("Usuário cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            // Retorno com erro de validação
            return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
        } catch (Exception e) {
            // Retorno genérico de erro (caso algum outro erro aconteça)
            return ResponseEntity.status(500).body("Erro inesperado ao cadastrar usuário.");
        }
    }
}

