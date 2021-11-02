package com.ebp.in.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Connection {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long connectionId;

	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long consumerNumber;


	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="user_id",referencedColumnName = "user_id")
	private Customer customerConnection;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id",referencedColumnName ="addressId")
	private Address connectionAddress;
	
	@Column
	@Enumerated(EnumType.STRING)
	private ConnectionType connectionType;

	@Column
	private Date applicationDate;
	
	@Column
	private Date connectionDate;

	@Column
	@Enumerated(EnumType.STRING)
	private ConnectionStatus connectionStatus;
	

	
	

	public Long getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(Long connectionId) {
		this.connectionId = connectionId;
	}

	public Long getConsumerNumber() {
		return consumerNumber;
	}

	public void setConsumerNumber(Long consumerNumber) {
		this.consumerNumber = consumerNumber;
	}

	public Customer getCustomerConnection() {
		return customerConnection;
	}

	public void setCustomerConnection(Customer customerConnection) {
		this.customerConnection = customerConnection;
	}

	public Address getConnectionAddress() {
		return connectionAddress;
	}

	public void setConnectionAddress(Address connectionAddress) {
		this.connectionAddress = connectionAddress;
	}

	public ConnectionType getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Date getConnectionDate() {
		return connectionDate;
	}

	public void setConnectionDate(Date connectionDate) {
		this.connectionDate = connectionDate;
	}

	public ConnectionStatus getConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(ConnectionStatus connectionStatus) {
		this.connectionStatus = connectionStatus;
	}
	
	
}
