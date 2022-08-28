package model.entities;

import model.exceptions.BusinessException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}	
	
	public void deposit(Double depositValue) {
		balance += depositValue;
	}
	
	public void withdraw(Double withdrawValue) {
		validateWithdraw(withdrawValue);
		balance -= withdrawValue;
		}
		
	private void validateWithdraw(double withdrawValue) {
		if (withdrawValue > getWithdrawLimit()) {
			throw new BusinessException("Error, the amount exceeds withdraw limit.");
		} 
		if (withdrawValue > getBalance()) {
			throw new BusinessException("Error, not enough balance.");
		}
	}
	
}
