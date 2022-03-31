package com.sts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int account_id;
	String account_number;
	@OneToOne(mappedBy = "account")
	@JsonBackReference
	private UserDetails userdetails;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", account_number=" + account_number + ", userdetails="
				+ userdetails + "]";
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public UserDetails getUserdetails() {
		return userdetails;
	}
	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}
	public Account(int account_id, String account_number, UserDetails userdetails) {
		super();
		this.account_id = account_id;
		this.account_number = account_number;
		this.userdetails = userdetails;
	}
	

}
