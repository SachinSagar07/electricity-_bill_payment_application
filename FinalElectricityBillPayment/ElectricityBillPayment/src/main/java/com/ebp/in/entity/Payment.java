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

public class Payment  {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long paymentId;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="bill_fk",referencedColumnName="billId")
	private Bill billPayment;
	
	@Column
	private Date paymentDate;
	
	@Enumerated(EnumType.STRING)
	@Column
	private PaymentMode paymentMode;
	
	@Column
	private double latePaymentCharges;
	
	@Column
	private double totalPaid;
	
	@Enumerated(EnumType.STRING)
	@Column
	private PaymentStatus status;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Bill getBillPayment() {
		return billPayment;
	}

	public void setBillPayment(Bill billPayment) {
		this.billPayment = billPayment;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public double getLatePaymentCharges() {
		return latePaymentCharges;
	}

	public void setLatePaymentCharges(double latePaymentCharges) {
		this.latePaymentCharges = latePaymentCharges;
	}

	public double getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	
	

	}