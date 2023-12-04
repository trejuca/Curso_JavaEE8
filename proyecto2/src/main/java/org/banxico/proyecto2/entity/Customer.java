package org.banxico.proyecto2.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
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
	@Column(name = "address_id")
	private Integer addressId;
	@Column
	private Character active;
	@Column(name = "create_date")
	private Date createDate;
	@Column(name = "last_update")
	private Date lastUpdate;
	
}
