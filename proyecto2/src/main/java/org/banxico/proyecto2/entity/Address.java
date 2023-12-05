package org.banxico.proyecto2.entity;

import java.util.Date;

import jakarta.enterprise.inject.Model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "address")
@Entity
@NamedQuery(
		name = "Address.findMax",
		query = "SELECT max(a.addressId) FROM Address a")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer addressId;
	@Column
	private String address;
	@Column(name = "city_id")
	private Integer cityId;
	@Column(name = "postal_code")
	private String postalCode;
	@Column
	private String phone;
	@Column
	private String district;
	@Column(name = "last_update")
	private Date lastUpdate;
	@OneToOne(
		fetch = FetchType.LAZY,
		mappedBy = "address")
	private Customer customer;

}
