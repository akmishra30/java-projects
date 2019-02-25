package com.makhir.jboss.drools.entity;

public class CreditCard {
	String name;
	String cardNo;
	String expire;
	String type;
	String bank;
	double discount;
	
	public CreditCard() {
		
	}
	public CreditCard(String name, String cardNo, String expire, String type, String bank) {
		this.name = name;
		this.cardNo = cardNo;
		this.expire = expire;
		this.type = type;
		this.bank = bank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getExpire() {
		return expire;
	}
	public void setExpire(String expire) {
		this.expire = expire;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	@Override
	public String toString() {
		return "CreditCard [name=" + name + ", cardNo=" + cardNo + ", expire=" + expire + ", type=" + type + ", bank="
				+ bank + ", discount=" + discount + "]";
	}
}
