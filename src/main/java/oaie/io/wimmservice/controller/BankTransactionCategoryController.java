package oaie.io.wimmservice.controller;

import oaie.io.wimmservice.dao.BankCategoryRepository;
import oaie.io.wimmservice.entities.BankTransactionCategory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class BankTransactionCategoryController {

    private final BankCategoryRepository categoryRepository;

    BankTransactionCategoryController(BankCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    List<BankTransactionCategory> all() {
        return categoryRepository.findAll();
    }


    @GetMapping("/categories/{id}")
    BankTransactionCategory specificCategory(@PathVariable String categoryName) {
        return categoryRepository.findCategoryByName(categoryName);
    }

    @PostMapping("/categories")
    BankTransactionCategory createNewCategory(@RequestBody BankTransactionCategory newCategory) {
        return categoryRepository.save(newCategory);
    }

    @PutMapping("/categories/{categoryName}")
    BankTransactionCategory updateCategoryName(@PathVariable String categoryName, @RequestBody BankTransactionCategory categoryToBeUpdated) {
        BankTransactionCategory category = categoryRepository.findCategoryByName(categoryName);
        category.setCategoryDescription(categoryToBeUpdated.getCategoryDescription());
        return categoryRepository.save(category);
    }

    @DeleteMapping("/category/{categoryName}")
    void deleteCategory(@PathVariable String categoryName) {
        BankTransactionCategory category = categoryRepository.findCategoryByName(categoryName);
        categoryRepository.delete(category);
    }

}
