package ocd.cache.repository;

import ocd.cache.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {

    // This repository interface will automatically inherit methods for CRUD operations
    // from JpaRepository, such as save, findById, findAll, deleteById, etc.
    // Additional custom query methods can be defined here if needed.

    List<Category> findAllByParentIsNull();
    List<Category> findAllByParentId(String parentId);
}
