package ocd.cache.service;


import ocd.cache.dto.CategoryResponse;
import ocd.cache.entity.Category;
import ocd.cache.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public List<CategoryResponse> findAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponse> responses = categories.stream().map(category -> {
            return CategoryResponse.builder().id(category.getId()).name(category.getName()).build();
        }).toList();

        for(CategoryResponse response : responses) {
            List<Category> children = categoryRepository.findAllByParentId(response.getId());
            List<CategoryResponse> childrenResponses = children.stream().map(child -> {
                return CategoryResponse.builder().id(child.getId()).name(child.getName()).build();
            }).toList();

            response.setChildren(childrenResponses);
        }

        return responses;
    }


}
