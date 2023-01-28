package com.techgen.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "citizen")
public class Citizen {

	@Id
	private Long id;

	private String name;

	private int age;

	private String gender;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "aadhar_id")
	@MapsId
	private Aadhar aadhar;

	public Citizen(String name, int age, String gender, Aadhar aadhar) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.aadhar = aadhar;
	}

}
