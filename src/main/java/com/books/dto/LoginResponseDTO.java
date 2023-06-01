package com.books.dto;

import com.books.models.Usuario;

public class LoginResponseDTO {
    private Usuario user;
    private String jwt;

    public LoginResponseDTO(){
        super();
    }

    public LoginResponseDTO(Usuario user, String jwt){
        this.user = user;
        this.jwt = jwt;
    }

    public Usuario getUser(){
        return this.user;
    }

    public void setUser(Usuario user){
        this.user = user;
    }

    public String getJwt(){
        return this.jwt;
    }

    public void setJwt(String jwt){
        this.jwt = jwt;
    }

}
