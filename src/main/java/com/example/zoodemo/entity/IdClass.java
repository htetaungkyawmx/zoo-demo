package com.example.zoodemo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class IdClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
