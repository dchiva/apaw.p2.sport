package es.upm.miw.apiSport.exceptions;

public class ObjectAlreadyExist extends Exception{


	public static final String DESCRIPTION = "No se puede añadir un registro ya existente";

	public ObjectAlreadyExist(String detail) {
		super(DESCRIPTION + " (" + detail+")");
	}

	public ObjectAlreadyExist() {
		this("");
	}
}
