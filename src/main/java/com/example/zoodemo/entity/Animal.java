package com.example.zoodemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Animal extends IdClass{
    private String type;
    private int totalNum;
    @OneToOne(mappedBy = "animal",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private Cage cage;
    @ManyToOne
    private Category category;
    @ManyToMany
    private List<FoodItem> foodItems=
            new ArrayList<>();

    public Animal(String type, int totalNum) {
        this.type = type;
        this.totalNum = totalNum;
    }
}