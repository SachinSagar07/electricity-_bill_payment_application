package com.ebp.in.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long addressId;
	
	@Column
	private int flatOrHouseNumber;
	
	@Column
	private String buildingName;
	
	@Column
	private String landmark;
	
	@Column
	private String village;
	
	@Column
	private String taluk;
	
	@Column
	private String district;
	
	@Column
	private String state;
	
	@Column
	private String pincode;
	
	
}
