package com.ebp.in.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reading {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long readingId;

	@Column
	private Double unitsConsumed;

	@Column
	private String readingPhoto;

	@Column
	private Date readingDate;

	@Column
	private Double pricePerUnits;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "connection_id_fk", referencedColumnName = "connectionId")
	private Connection readingForConnection;

	public Long getReadingId() {
		return readingId;
	}

	public void setReadingId(Long readingId) {
		this.readingId = readingId;
	}

	public Double getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(Double unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public String getReadingPhoto() {
		return readingPhoto;
	}

	public void setReadingPhoto(String readingPhoto) {
		this.readingPhoto = readingPhoto;
	}

	public Date getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(Date readingDate) {
		this.readingDate = readingDate;
	}

	public Double getPricePerUnits() {
		return pricePerUnits;
	}

	public void setPricePerUnits(Double pricePerUnits) {
		this.pricePerUnits = pricePerUnits;
	}

	public Connection getReadingForConnection() {
		return readingForConnection;
	}

	public void setReadingForConnection(Connection readingForConnection) {
		this.readingForConnection = readingForConnection;
	}
	
	

}