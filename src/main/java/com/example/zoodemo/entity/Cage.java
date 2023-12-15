package com.example.zoodemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cage extends IdClass {

    private String cageNum;
    private String location;
    @OneToOne(mappedBy = "cage")
//    @JoinColumn(name = "animal_id_fk")
    private Animal animal;

    public Cage(String cageNum, String location) {
        this.cageNum = cageNum;
        this.location = location;
    }
}
