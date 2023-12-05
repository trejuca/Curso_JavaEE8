package org.banxico.proyecto2.dto;

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
@Model
public class Address {

	private Integer addressId;
	private String address;
	private Integer cityId;
	private String postalCode;
	private String phone;
	private String district;
	private Date lastUpdate;

}
