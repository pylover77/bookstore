package com.books.services;

import com.books.exception.Response;
import com.books.models.Livro;
import com.books.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private Response rex;

    public Iterable<Livro> listar(){
        return livroRepository.findAll();
    }

    public ResponseEntity<?> CadastrarAlterar(Livro book, String action) {
        if (book.getNome().equals("")) {
            rex.setMsg("o nome do produto é obrigatorio!");
            return new ResponseEntity<Response>(rex, HttpStatus.BAD_REQUEST);

        } else if (book.getAutor().equals("")) {
            rex.setMsg("o nome do autor é obrigatorio!");
            return new ResponseEntity<Response>(rex, HttpStatus.BAD_REQUEST);
        } else if (book.getPreco() == null || book.getPreco() < 1) {
            rex.setMsg("o preço é obrigatorio!");
            return new ResponseEntity<Response>(rex, HttpStatus.BAD_REQUEST);

        } else {
            if (action.equals("cadastrar")) {
                return new ResponseEntity<Livro>(livroRepository.save(book), HttpStatus.CREATED);

            } else {
                return new ResponseEntity<Livro>(livroRepository.save(book), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<Response> remover(Integer id){
        livroRepository.deleteById(id);
        rex.setMsg("Produto removido!");
        return new ResponseEntity<Response>(rex, HttpStatus.OK);

    }
}

