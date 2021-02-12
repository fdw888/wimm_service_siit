package oaie.io.wimmservice.dao;

import oaie.io.wimmservice.entities.BankTransaction;
import oaie.io.wimmservice.entities.BankTransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BankTransactionsRepository extends JpaRepository<BankTransaction, Long> {



    @Query(value = "SELECT * FROM bank_transactions bt WHERE bt.bank_transaction_iban =:iban", nativeQuery = true)
    public List<BankTransaction> findBankTransactionByIban(String iban);

    @Query(value ="SELECT * FROM bank_transactions bt INNER JOIN categories c ON c.id =bt.id_category AND c.category_name =UPPER(:categoryName)",nativeQuery = true)
    public List<BankTransaction> findTransactionsByCategoryName(String categoryName);

}
