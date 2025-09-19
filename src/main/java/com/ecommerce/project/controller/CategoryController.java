package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")// we can say in this class all end points start with /api (url pattern)
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/public/categories")
    //@RequestMapping(value ="api/public/categories",method = RequestMethod.GET)
    // we can use Request Mapping instead of individual Mappings as shown above
    public ResponseEntity<List<Category>> getAllCategories()
    {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category)
    {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category Added Successfully",HttpStatus.CREATED);

    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId)
    {
        try {
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK); // most common way
            // return ResponseEntity.ok(status);
           //  return ResponseEntity.status(HttpStatus.OK).body(status);
        } catch (ResponseStatusException e)
        {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }

    }
    @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,
                                                   @PathVariable Long categoryId)
    {
        try{
            Category savedCategory = categoryService.updateCategory(category,categoryId);
            return new ResponseEntity<>("Updated Category with Category id: "+categoryId, HttpStatus.OK);

        }catch(ResponseStatusException e)
        {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }





}
