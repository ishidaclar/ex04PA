package com.clara.ex04.services;

import com.clara.ex04.model.AutorModel;
import com.clara.ex04.repositorie.AutorRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServices {

    @Autowired
    private AutorRepositorie autorRepositorie;

    public List<AutorModel> findAll(){
       return autorRepositorie.findAll();
    }

    public AutorModel criarAutor(AutorModel autor){
        return autorRepositorie.save(autor);
    }

    public Optional<AutorModel> findById(Long id){
        return autorRepositorie.findById(id);
    }
    public AutorModel atualizarAutor(Long id, AutorModel autor){
        AutorModel model = autorRepositorie.findById(id).get();
        model.setNome(autor.getNome());
        return autorRepositorie.save(model);
    }

    public void deletarAutor(Long id){
        autorRepositorie.deleteById(id);
    }
}
