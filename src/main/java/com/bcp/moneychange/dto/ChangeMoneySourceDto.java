package com.bcp.moneychange.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ChangeMoneySourceDto {

    private BigDecimal amount;
    private String sourceCurrency;
    private String destinationCurrency;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    @Override
    public String toString() {
        return "ChangeMoneySourceDto{" +
                "amount=" + amount +
                ", sourceCurrency='" + sourceCurrency + '\'' +
                ", destinationCurrency='" + destinationCurrency + '\'' +
                '}';
    }
}
