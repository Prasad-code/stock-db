package com.db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quote")
public class Quote {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String username;
	
	private String quote;

	public Quote() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Quote(String username, String quote) {
		super();
		this.username = username;
		this.quote = quote;
	}


	public Quote(Integer id, String username, String quote) {
		super();
		this.id = id;
		this.username = username;
		this.quote = quote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", username=" + username + ", quote=" + quote + "]";
	}
	
	

}
