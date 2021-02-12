package wimmservice.utils;

import java.math.BigDecimal;

//@JsonIgnoreProperties(ignoreUnknown=true)
public class BankTransactionLine {

    private String bankTransactionDate;
    private BigDecimal bankTransactionAmount;
    private String bankTransactionType;
    private String bankTransactionReference;
    private String bankTransactionCategory;
    private String bankTransactionIban;

    public BankTransactionLine() {

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

    @Override
    public String toString() {
        return "BankTransactionLine{" +
                "bankTransactionDate='" + bankTransactionDate + '\'' +
                ", bankTransactionAmount=" + bankTransactionAmount +
                ", bankTransactionType='" + bankTransactionType + '\'' +
                ", bankTransactionReference='" + bankTransactionReference + '\'' +
                ", bankTransactionCategory='" + bankTransactionCategory + '\'' +
                ", bankTransactionIban='" + bankTransactionIban + '\'' +
                '}';
    }
}
