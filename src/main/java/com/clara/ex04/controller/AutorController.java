package com.clara.ex04.controller;

import com.clara.ex04.model.AutorModel;
import com.clara.ex04.repositorie.AutorRepositorie;
import com.clara.ex04.services.AutorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/{id}")

public class AutorController {

@Autowired
    private AutorServices autorServices;

@GetMapping
    public ResponseEntity<List<AutorModel>> findAll(){
    List<AutorModel> requeste = autorServices.findAll();
    return ResponseEntity.ok().body(requeste);
}

@PostMapping
    public ResponseEntity<AutorModel> criar(@RequestBody AutorModel autorModel){
    AutorModel requeste = autorServices.criarAutor(autorModel);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autorModel.getId()).toUri();
    return ResponseEntity.created(uri).body(requeste);
}

@GetMapping
    public Optional<AutorModel> findAll(@PathVariable Long id){
    return autorServices.findById(id);
}


}
