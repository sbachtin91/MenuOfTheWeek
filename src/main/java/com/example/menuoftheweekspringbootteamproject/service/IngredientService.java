package com.example.menuoftheweekspringbootteamproject.service;


import com.example.menuoftheweekspringbootteamproject.dao.IngredientRepository;
import com.example.menuoftheweekspringbootteamproject.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository repository;


    public List<Ingredient> findAll(){
          Iterable<Ingredient> ingredients = repository.findAll();
          return (List<Ingredient>) ingredients;

    }

    public void save(Ingredient ingredient){
        repository.save(ingredient);
    }

    public Ingredient get(Integer id){
        Optional<Ingredient> ingredient = repository.findById(id);
        if (ingredient.isPresent()){
            return ingredient.get();
        }  else {
            return null;
        }

    }

    public List<Ingredient> findByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);

    }
}
