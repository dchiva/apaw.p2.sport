package es.upm.miw.apiSport.controllers;

import es.upm.miw.apiSport.daos.DaoFactory;
import es.upm.miw.apiSport.entities.Sport;

public class SportController {

	public boolean createSport(String sportName){
		Sport sport=DaoFactory.getFactory().getSportDao().getSport(sportName);
		if(sport==null){
			DaoFactory.getFactory().getSportDao().create(new Sport(sportName));
			return true;
		}
		return false;
	}
	public boolean existsSport(String sportName){
		return DaoFactory.getFactory().getSportDao().getSport(sportName)!=null;
	}
}
