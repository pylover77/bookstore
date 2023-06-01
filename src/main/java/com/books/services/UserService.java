package com.books.services;

import com.books.exception.Response;
import com.books.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.books.repository.UsuarioRepository;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private Response rex;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("In the user details service");

        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
    }

    public Iterable<Usuario> UsuarioListar(){
        return userRepository.findAll();
    }

    public ResponseEntity<Response> UsuarioRemover(Integer id){
        userRepository.deleteById(id);
        rex.setMsg("usuario removido!");
        return new ResponseEntity<Response>(rex, HttpStatus.OK);
    }
}
