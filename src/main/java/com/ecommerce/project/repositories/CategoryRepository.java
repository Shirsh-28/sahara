package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CategoryRepository extends JpaRepository<Category,Long> {
    Category findByCategoryName(@NotBlank @Size(min = 5,message = "Category name should have at least 5 characters") String categoryName);
    //Type of entity and type of Primary Key of Identity
    // we dont have to write implementation code Spring data jpa automatically generate impl.
}
