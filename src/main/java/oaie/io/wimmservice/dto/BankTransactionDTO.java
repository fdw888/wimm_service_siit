package oaie.io.wimmservice.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;



import java.math.BigDecimal;
import java.util.Date;

@Document(indexName = "bank_transactions")
public class BankTransactionDTO {
   @Id
    private Long id;
    private String bankTransactionDate;
    private BigDecimal bankTransactionAmount;

    private String bankTransactionType;

    private String bankTransactionReference;

    private String bankTransactionCategory;

    private String bankTransactionIban;

    public BankTransactionDTO() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankTransactionDate() {
        return bankTransactionDate;
    }

    public void setBankTransactionDate(String bankTransactionDate) {
        this.bankTransactionDate = bankTransactionDate;
    }

    public BigDecimal getBankTransactionAmount() {
        return bankTransactionAmount;
    }

    public void setBankTransactionAmount(BigDecimal bankTransactionAmount) {
        this.bankTransactionAmount = bankTransactionAmount;
    }

    public String getBankTransactionType() {
        return bankTransactionType;
    }

    public void setBankTransactionType(String bankTransactionType) {
        this.bankTransactionType = bankTransactionType;
    }

    public String getBankTransactionReference() {
        return bankTransactionReference;
    }

    public void setBankTransactionReference(String bankTransactionReference) {
        this.bankTransactionReference = bankTransactionReference;
    }


    public String getBankTransactionCategory() {
        return bankTransactionCategory;
    }

    public void setBankTransactionCategory(String bankTransactionCategory) {
        this.bankTransactionCategory = bankTransactionCategory;
    }

    public String getBankTransactionIban() {
        return bankTransactionIban;
    }

    public void setBankTransactionIban(String bankTransactionIban) {
        this.bankTransactionIban = bankTransactionIban;
    }
}
