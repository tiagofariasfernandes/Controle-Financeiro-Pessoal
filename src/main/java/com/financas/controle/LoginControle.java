package com.financas.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.dto.LoginDto;
import com.financas.service.LoginService;

@RestController
@RequestMapping("api/login")
public class LoginControle {

      @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity <String> logar (@RequestBody LoginDto loginDto){
        boolean loginValido = loginService.logar(loginDto);

        if(loginValido){
            return ResponseEntity.ok("Login bem sucedido!");
            
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais invalidas");
        }

    }

    
}
