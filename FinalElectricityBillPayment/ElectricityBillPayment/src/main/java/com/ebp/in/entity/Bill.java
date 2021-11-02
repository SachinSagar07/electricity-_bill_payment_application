package com.ebp.in.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bill 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long billId;
	@Column
	private Date billDate;
	@Column
	private LocalDate billDueDate;
	@Column
	private double unitsConsumed;
	@Column
	private double billAmount;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="reading_fk",referencedColumnName="readingId")
	private Reading billForReading;

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public LocalDate getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(LocalDate billDueDate) {
		this.billDueDate = billDueDate;
	}

	public double getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(double unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public Reading getBillForReading() {
		return billForReading;
	}

	public void setBillForReading(Reading billForReading) {
		this.billForReading = billForReading;
	}
	
	

}
