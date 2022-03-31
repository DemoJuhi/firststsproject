package com.sts.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "User_details")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", account=" + account + "]";
	}
	String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	Account account;
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDetails(int id, String name, Account account) {
		super();
		this.id = id;
		this.name = name;
		
		this.account = account;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	

}
