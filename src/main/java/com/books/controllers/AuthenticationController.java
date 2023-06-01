package com.books.controllers;

import com.books.exception.Response;
import com.books.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.books.models.Usuario;
import com.books.dto.LoginResponseDTO;
import com.books.dto.RegistrationDTO;
import com.books.services.AuthenticationService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Usuario registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }
    
    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }

    @GetMapping("/listar")
    public Iterable<Usuario> UsuarioListar(){
        return userService.UsuarioListar();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> UsuarioRemover(@PathVariable Integer id){
        return userService.UsuarioRemover(id);
    }
}   
