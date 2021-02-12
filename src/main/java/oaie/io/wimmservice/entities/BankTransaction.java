package oaie.io.wimmservice.entities;

import oaie.io.wimmservice.dto.BankTransactionDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "BANK_TRANSACTIONS")
public class BankTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BANK_TRANSACTION_DATE")
    private Date bankTransactionDate;

    @NotNull
    @Column(name = "AMOUNT")
    private BigDecimal amount;


    @Column(name = "BANK_TRANSACTION_TYPE")
    private String bankTransactionType;


    @Column(name = "BANK_TRANSACTION_DETAILS")
    private String bankTransactionReference;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORY")
    private BankTransactionCategory category;

    @Column(name = "BANK_TRANSACTION_IBAN")
    private String bankTransactionIban;


    public BankTransaction() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBankTransactionDate() {
        return bankTransactionDate;
    }

    public void setBankTransactionDate(Date bankTransactionDate) {
        this.bankTransactionDate = bankTransactionDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public BankTransactionCategory getCategory() {
        return category;
    }

    public void setCategory(BankTransactionCategory category) {
        this.category = category;
    }

    public String getBankTransactionIban() {
        return bankTransactionIban;
    }

    public void setBankTransactionIban(String bankTransactionIban) {
        this.bankTransactionIban = bankTransactionIban;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "bankTransactionType='" + bankTransactionType + '\'' +
                '}';
    }

    public BankTransactionDTO convertToDTO() {
        BankTransactionDTO dto = new BankTransactionDTO();
        // set values from entity to dto

        return dto;
    }
}
