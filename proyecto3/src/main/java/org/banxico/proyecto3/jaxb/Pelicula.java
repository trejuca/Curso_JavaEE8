package org.banxico.proyecto3.jaxb;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "pelicula")
@XmlType(propOrder = {"id", "titulo", "genero", "anioLanzamiento","actores"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Pelicula {

	@XmlAttribute
	private Integer id;
	@XmlElement
	private String titulo;
	@XmlElement
	private String genero;
	@XmlElement
	private Integer anioLanzamiento;
	@XmlElement(name = "actor")
	@XmlElementWrapper(name = "actores")
	private List<Actor> actores;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getAnioLanzamiento() {
		return anioLanzamiento;
	}
	public void setAnioLanzamiento(Integer anioLanzamiento) {
		this.anioLanzamiento = anioLanzamiento;
	}
	public List<Actor> getActores() {
		return actores;
	}
	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}
}
