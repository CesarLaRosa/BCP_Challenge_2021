package com.bcp.moneychange.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ChangeMoneyResponseDto {

	private BigDecimal amount;
	private BigDecimal amountTypeChange;
	private String sourceCurrency;
	private String destinationCurrency;
	private BigDecimal typeChange;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmountTypeChange() {
		return amountTypeChange;
	}

	public void setAmountTypeChange(BigDecimal amountTypeChange) {
		this.amountTypeChange = amountTypeChange;
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

	public BigDecimal getTypeChange() {
		return typeChange;
	}

	public void setTypeChange(BigDecimal typeChange) {
		this.typeChange = typeChange;
	}

	@Override
	public String toString() {
		return "ChangeMoneyResponseDto{" +
				"amount=" + amount +
				", amountTypeChange=" + amountTypeChange +
				", sourceCurrency='" + sourceCurrency + '\'' +
				", destinationCurrency='" + destinationCurrency + '\'' +
				", typeChange=" + typeChange +
				'}';
	}
}
