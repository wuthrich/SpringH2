package com.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Usuario;
import com.test.exceptions.UsuarioNotFoundException;
import com.test.repository.UsuarioRepository;

@RestController
class UsuarioController {

  private final UsuarioRepository repository;

  UsuarioController(UsuarioRepository repository) {
    this.repository = repository;
  }
 
  @GetMapping("/usuario")
  List<Usuario> all() {
    return repository.findAll();
  }
  
  @PostMapping("/usuario")
  Usuario newEmployee(@RequestBody Usuario newUsuario) {
    return repository.save(newUsuario);
  }
 
  @GetMapping("/usuario/{id}")
  Usuario one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new UsuarioNotFoundException(id));
  }

  @PutMapping("/usuario/{id}")
  Usuario replaceUsuario(@RequestBody Usuario newUsuario, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(usuario -> {
        usuario.setNombres(newUsuario.getNombres());
        usuario.setApellidos(newUsuario.getApellidos());
        usuario.setEdad(newUsuario.getEdad());
        usuario.setDocumento(newUsuario.getDocumento());
        return repository.save(usuario);
      })
      .orElseGet(() -> {
    	  newUsuario.setId(id);
        return repository.save(newUsuario);
      });
  }

  @DeleteMapping("/usuario/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}