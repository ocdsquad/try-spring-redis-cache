package ocd.cache.controller;


import lombok.RequiredArgsConstructor;
import ocd.cache.dto.CategoryResponse;
import ocd.cache.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CategoryController {
    private final CategoryService categoryService;

    /**
     * Find all categories.
     *
     * @return List of CategoryResponse
     */
    @GetMapping("/categories")
    public List<CategoryResponse> findAll(){
        return categoryService.findAll();
    }
}
