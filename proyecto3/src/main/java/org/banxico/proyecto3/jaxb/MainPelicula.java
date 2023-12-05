package org.banxico.proyecto3.jaxb;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class MainPelicula {
	public static void main(String[] args) {
		
		try {
			marshall();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void marshall() throws JAXBException {
		Actor actor1 = new Actor();
		actor1.setId(1);
		actor1.setNombre("Actor1");
		actor1.setFechaNacimiento(new Date());
		
		Actor actor2 = new Actor();
		actor2.setId(2);
		actor2.setNombre("Actor2");
		actor2.setFechaNacimiento(new Date());
		
		List<Actor> actores = new ArrayList<>();
		actores.add(actor1);
		actores.add(actor2);
		
		Pelicula pelicula1 = new Pelicula();
		pelicula1.setGenero("suspenso");
		pelicula1.setAnioLanzamiento(2020);
		pelicula1.setId(1);
		pelicula1.setTitulo("Titulo del a pelicula");
		pelicula1.setActores(actores);
		
		JAXBContext context = JAXBContext.newInstance(Pelicula.class);
		
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(pelicula1, new File("./pelicula.xml"));
	}
	
	public static Pelicula unmarshall() throws JAXBException {
		
		JAXBContext context = JAXBContext.newInstance(Pelicula.class);
		return (Pelicula)context.createUnmarshaller().unmarshal(
				new File("./pelicula.xml"));
	}
}
