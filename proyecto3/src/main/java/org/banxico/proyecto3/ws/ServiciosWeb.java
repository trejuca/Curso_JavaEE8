package org.banxico.proyecto3.ws;

import java.util.Date;

import org.banxico.proyecto3.jaxb.Empleado;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(serviceName = "ejercicios")
public class ServiciosWeb {

	@WebMethod(operationName = "ejercicio41")
	public String ejercicio41() {
		return "Hola servicio";
	}
	
	public Empleado ejercicio42() {
		Empleado e = new Empleado();
		e.setApellido("Perez");
		e.setNombre("Juan");
		e.setFechaNacimiento(new Date());
		e.setId(1);
		
		return e;
	}
}
