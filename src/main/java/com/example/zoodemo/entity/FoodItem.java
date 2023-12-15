package com.example.zoodemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FoodItem extends IdClass{
    private String name;
    private int quantity;
    @ManyToOne
    private Supplier supplier;
    @ManyToMany
    private List<Animal> animals=
            new ArrayList<>();

    public FoodItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
