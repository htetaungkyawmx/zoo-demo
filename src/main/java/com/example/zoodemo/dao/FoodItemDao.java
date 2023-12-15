package com.example.zoodemo.dao;

import com.example.zoodemo.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemDao extends JpaRepository<FoodItem,Integer> {

}
