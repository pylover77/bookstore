package com.books.controllers;

import com.books.exception.Response;
import com.books.models.Livro;
import com.books.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Livro book){
        return livroService.CadastrarAlterar(book, "alterar");
    }

    @GetMapping("/listar")
    public Iterable<Livro> listar(){
        return livroService.listar();
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Response> remover(@PathVariable Integer id) {
        livroService.remover(id);
        Response response = new Response();
        response.setMsg("Livro removido!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
