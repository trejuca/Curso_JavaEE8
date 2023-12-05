package org.banxico.proyecto3.jaxb;

import java.io.File;
import java.util.Date;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class Main {

	public static void main(String[] args) {
		try {
			marshall();
			/*
			 * Empleado empleado = unmarshall(); System.out.println(empleado);
			 */
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void marshall() throws JAXBException {
		Empleado empleado = new Empleado();
		empleado.setNombre("Juan");
		empleado.setApellido("Perez");
		empleado.setId(1);
		empleado.setFechaNacimiento(new Date());
		
		JAXBContext context = JAXBContext.newInstance(Empleado.class);
		
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(empleado, new File("./empleado.xml"));
	}
	
	public static Empleado unmarshall() throws JAXBException {
		
		JAXBContext context = JAXBContext.newInstance(Empleado.class);
		return (Empleado)context.createUnmarshaller().unmarshal(new File("./empleado.xml"));
	}
}
