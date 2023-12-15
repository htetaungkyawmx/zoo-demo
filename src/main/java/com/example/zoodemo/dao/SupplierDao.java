package com.example.zoodemo.dao;

import com.example.zoodemo.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierDao extends JpaRepository<Supplier,Integer> {

}
