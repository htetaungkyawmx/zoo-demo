package com.example.zoodemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
*
1.directionality - unit, bi
2.ownership - who is owner(
*
* */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Animal extends IdClass{
    private String type;
    private int totalNum;
    @OneToOne @JoinColumn(name = "cage_id_fk")
//    @JoinColumn(name = "cage_id_fk")
    private Cage cage;

    public Animal(String type) {
        this.type = type;
    }

    public Animal(String type, int totalNum) {
        this.type = type;
        this.totalNum = totalNum;
    }
}