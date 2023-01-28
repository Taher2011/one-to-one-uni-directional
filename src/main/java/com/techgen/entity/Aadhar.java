package com.techgen.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "aadhar")
public class Aadhar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "aadhar_number", unique = true)
	private String number;

	private String city;

	@Column(name = "created_date")
	private Date createdDate;

	public Aadhar(String number, String city, Date createdDate) {
		super();
		this.number = number;
		this.city = city;
		this.createdDate = createdDate;
	}

}
