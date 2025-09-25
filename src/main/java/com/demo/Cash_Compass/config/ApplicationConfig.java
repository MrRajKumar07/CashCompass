package com.demo.Cash_Compass.config;

import com.demo.Cash_Compass.entity.Category;
import com.demo.Cash_Compass.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    CommandLineRunner initDatabase(CategoryRepository categoryRepository) {
        return args -> {
            // Check if categories already exist to prevent duplicates
            if (categoryRepository.count() == 0) {
                categoryRepository.save(createCategory("Grocery", "Expense"));
                categoryRepository.save(createCategory("Food & Drinks", "Expense"));
                categoryRepository.save(createCategory("Clothes", "Expense"));
                categoryRepository.save(createCategory("Hotels", "Expense"));
                categoryRepository.save(createCategory("Medicines", "Expense"));
                categoryRepository.save(createCategory("Gifts", "Expense"));
                categoryRepository.save(createCategory("Fuels", "Expense"));
                categoryRepository.save(createCategory("Travels", "Expense"));
                categoryRepository.save(createCategory("Kids", "Expense"));
                categoryRepository.save(createCategory("Salary", "Income"));
            }
        };
    }

    private Category createCategory(String name, String type) {
        Category category = new Category();
        category.setName(name);
        category.setType(type);
        return category;
    }
}
