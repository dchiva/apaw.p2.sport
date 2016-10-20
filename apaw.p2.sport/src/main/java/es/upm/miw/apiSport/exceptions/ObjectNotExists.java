package es.upm.miw.apiSport.exceptions;

public class ObjectNotExists extends Exception{


	public static final String DESCRIPTION = "El registro al que se hace referencia no existe";

	public ObjectNotExists(String detail) {
		super(DESCRIPTION + " (" + detail+")");
	}

	public ObjectNotExists() {
		this("");
	}
	
}
