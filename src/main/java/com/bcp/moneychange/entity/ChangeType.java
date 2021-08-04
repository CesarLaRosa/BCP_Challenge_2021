package com.bcp.moneychange.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "change_type")
public class ChangeType {

    private long id;
    private String sourceCurrency;
    private String destinationCurrency;
    private BigDecimal changeTypeValue;

    public ChangeType () {}

    public ChangeType(String sourceCurrency, String destinationCurrency, BigDecimal changeTypeValue) {
        this.sourceCurrency = sourceCurrency;
        this.destinationCurrency = destinationCurrency;
        this.changeTypeValue = changeTypeValue;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "source_currency", nullable = false)
    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    @Column(name = "destination_currency", nullable = false)
    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    @Column(name = "change_type", nullable = false)
    public BigDecimal getChangeTypeValue() {
        return changeTypeValue;
    }

    public void setChangeTypeValue(BigDecimal changeTypeValue) {
        this.changeTypeValue = changeTypeValue;
    }
}
