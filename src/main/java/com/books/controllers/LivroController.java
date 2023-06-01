package com.books.controllers;

import com.books.models.Livro;
import com.books.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
@CrossOrigin("*")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Livro book){
        return livroService.CadastrarAlterar(book, "cadastrar");
    }

    @GetMapping("/listar")
    public Iterable<Livro> listar(){
        return livroService.listar();
    }


}
