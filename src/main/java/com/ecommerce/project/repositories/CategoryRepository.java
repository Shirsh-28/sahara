package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CategoryRepository extends JpaRepository<Category,Long> {
    //Type of entity and type of Primary Key of Identity
    // we dont have to write implementation code Spring data jpa automatically generate impl.
}
