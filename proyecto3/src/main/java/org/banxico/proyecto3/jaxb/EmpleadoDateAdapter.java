package org.banxico.proyecto3.jaxb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class EmpleadoDateAdapter extends XmlAdapter<String, Date> {

	private static DateFormat formatoFecha;
	
	static {
		formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
	}

	@Override
	public String marshal(Date v) throws Exception {
		return formatoFecha.format(v);
	}
	
	@Override
	public Date unmarshal(String v) throws Exception {
		return formatoFecha.parse(v);
	}


}
