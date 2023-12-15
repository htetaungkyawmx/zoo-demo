package com.example.zoodemo.dao;

import com.example.zoodemo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    @Query("select c from Category c join fetch c.animalList where c.categoryType = ?1")
    Category fetchCategory(String categoryType);
}
