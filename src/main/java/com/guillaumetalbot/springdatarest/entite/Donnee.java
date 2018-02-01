package com.guillaumetalbot.springdatarest.entite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Donnee implements Serializable {
	private static final long serialVersionUID = 1L;

	private String description;

	@Id
	@GeneratedValue
	private Long id;

	public Donnee() {
		super();
	}

	public Donnee(final String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public Long getId() {
		return this.id;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

}
