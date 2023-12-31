package org.banxico.proyecto2.entity;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
@NamedQuery(
		name = "Customer.findMax",
		query = "SELECT max(c.customerId) FROM Customer c")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer customerId;
	@Column(name = "store_id")
	private Integer storeId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column
	private String email;
	@Column
	private Character active;
	@Column(name = "create_date")
	private Date createDate;
	@Column(name = "last_update")
	private Date lastUpdate;
	@OneToOne(
		fetch = FetchType.EAGER,
		cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
}
