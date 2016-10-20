package es.upm.miw.apiSport.api;

import es.upm.miw.apiSport.controllers.SportController;
import es.upm.miw.apiSport.exceptions.ObjectAlreadyExist;

public class SportResource {
	
	public void createSport(String sportName) throws ObjectAlreadyExist{
		SportController sportController=new SportController();
		if(!sportController.createSport(sportName)){
			throw new ObjectAlreadyExist("El deporte "+sportName+" ya existe");
		}
	}

}
