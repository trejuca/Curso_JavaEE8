package org.banxico.proyecto2.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.banxico.proyecto2.entity.Customer;
import org.banxico.proyecto2.service.CustomerService;

import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
@Setter
@Getter
public class CustomerController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8547127012052329569L;

	@Inject
	private CustomerService customerService;
	
	private Integer customerId;
	private String firstName;
	private String lastName;
	private String email;
	private List<Customer> customersList;
	
	//Propiedad para guardar el total de filas de la tabla
	private int totalRows;
	//Propiedad para guardar la primera fila que queremos ubicar en la pagina
	private int firstRow;
	//Propiedad para guardar el total de filas por pagina
	private int rowsPerPage = 10;
	//Propiedad para guardar la pagina donde nos encontramos
	private int currentPage;
	
	@PostConstruct
	public void init() {
		if (customersList == null) {
			paginate(0);
		}
	}
	
	public String save() {
		Customer customer = new Customer();
		customer.setFirstName(getFirstName());
		customer.setLastName(getLastName());
		customer.setEmail(getEmail());
		customer.setStoreId(1);
		customer.setActive('1');
		customer.setAddressId(1);
		customer.setCreateDate(new Date());
		customer.setLastUpdate(new Date());
		
		/*if (getCustomerId() != 0) {
			customer.setCustomerId(getCustomerId());
			customerService.update(customer);
			return "customer";
		}*/
		
		customerService.save(customer);
		return "customer";
	}
	
	public String delete(int id) {
		System.out.println("Eliminar con id: " + id);
		customerService.delete(id);
		return "customer";
	}
	
	public void paginate(int firstRow) {
		this.firstRow = firstRow;
		int range[] = {rowsPerPage, firstRow};
		
		setCustomersList(customerService.findRange(range));
		currentPage = firstRow / rowsPerPage;
	}
	
	public void firstPage() {
		paginate(0);
	}
	
	public void previousPage() {
		paginate((currentPage * rowsPerPage) - rowsPerPage);
	}
	
	public void nextPage() {
		paginate((currentPage * rowsPerPage) + rowsPerPage);
	}
	
	public void lastPage() {
		paginate((totalRows / rowsPerPage) * rowsPerPage);
	}
}
