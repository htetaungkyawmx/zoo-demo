package com.example.zoodemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category extends IdClass{
    private String categoryType;

    @OneToMany(mappedBy = "category")
    private List<Animal> animalList=
            new ArrayList<>();

    public void addAnimal(Animal animal){
        animal.setCategory(this);
        animalList.add(animal);
    }
}
