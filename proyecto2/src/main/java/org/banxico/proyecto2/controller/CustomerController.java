package org.banxico.proyecto2.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.banxico.proyecto2.entity.Address;
import org.banxico.proyecto2.entity.City;
import org.banxico.proyecto2.entity.Customer;
import org.banxico.proyecto2.helper.ConverterHelper;
import org.banxico.proyecto2.service.CityService;
import org.banxico.proyecto2.service.CustomerService;

import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.control.RequestContextController;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
@Setter
@Getter
public class CustomerController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8547127012052329569L;

	@Inject
	private CustomerService customerService;
	@Inject
	private CityService cityService;
	
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	
	private Address address;
	
	private List<Customer> customersList;
	private List<City> citiesList;
	
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
		address = new Address();
		
		if (customersList == null) {
			paginate(0);
		}
		setCitiesList(cityService.findAll());
	}
	
	public String save() {
		Customer customer = new Customer();
		customer.setFirstName(getFirstName());
		customer.setLastName(getLastName());
		customer.setEmail(getEmail());
		customer.setStoreId(1);
		customer.setActive('1');
		customer.setCreateDate(new Date());
		customer.setLastUpdate(new Date());
		
		/*Address address = new Address();
		address.setAddress("Direccion conocida");
		address.setDistrict("Distrito conocido");
		address.setCityId(300);
		address.setPostalCode("06000");
		address.setPhone("555555");
		address.setLastUpdate(new Date());*/
		
		address.setCityId(300);
		address.setLastUpdate(new Date());
		
		customer.setAddress(address);
		address.setCustomer(customer);
		
		if (getCustomerId() != 0) {
			System.out.println("Actualiza con id: " + getCustomerId());
			customer.setCustomerId(getCustomerId());
			customerService.update(customer);
			return "customer";
		}
		
		customerService.save(customer);

		return "customer";
	}
	
	public String delete(int id) {
		System.out.println("Eliminar con id: " + id);
		customerService.delete(id);
		return "customer";
	}
	
	public void loadCustomer(int id) {
		Customer customer = customerService.findById(id);
		setFirstName(customer.getFirstName());
		setLastName(customer.getLastName());
		setEmail(customer.getEmail());
		setCustomerId(customer.getCustomerId());
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
