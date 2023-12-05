package org.banxico.proyecto2.helper;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.management.RuntimeErrorException;

public class ConverterHelper {

	private final static SimpleDateFormat DATE_TIME_FORMAT 
		= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Timestamp parseTimeStamp(String timestamp) {
		try {
			return new Timestamp(DATE_TIME_FORMAT.parse(timestamp).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IllegalArgumentException(e.getMessage());
		}
	}
}
