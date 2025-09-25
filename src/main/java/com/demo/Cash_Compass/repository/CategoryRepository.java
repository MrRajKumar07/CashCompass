package com.demo.Cash_Compass.repository;

import com.demo.Cash_Compass.entity.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	List<Category> findByUserId(String userId);
}
