package oaie.io.wimmservice.dao;

import oaie.io.wimmservice.entities.BankTransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BankCategoryRepository extends JpaRepository<BankTransactionCategory, Long> {

    @Query(value = "SELECT * FROM categories c WHERE c.category_name =:categoryName", nativeQuery = true)
    public BankTransactionCategory findCategoryByName(String categoryName);

    @Query(value ="UPDATE categories c SET c.category_description =:categoryDescription WHERE c.id=:categoryId", nativeQuery = true)
    public BankTransactionCategory updateCategoryDescription(String categoryDescription, Long categoryId);
}