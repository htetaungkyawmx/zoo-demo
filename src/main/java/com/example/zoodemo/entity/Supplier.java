package com.example.zoodemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Supplier extends IdClass{
     private String supplierName;
     private String contactNum;
     private String address;

     @OneToMany(mappedBy = "supplier",
     cascade = CascadeType.ALL,orphanRemoval = true)
     private List<FoodItem> foodItems=
             new ArrayList<>();

     public void addFoodItem(FoodItem foodItem){
         foodItem.setSupplier(this);
         foodItems.add(foodItem);
     }
    public Supplier(String supplierName, String contactNum, String address) {
        this.supplierName = supplierName;
        this.contactNum = contactNum;
        this.address = address;
    }

}
