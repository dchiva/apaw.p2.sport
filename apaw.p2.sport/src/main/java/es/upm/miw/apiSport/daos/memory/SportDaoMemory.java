package es.upm.miw.apiSport.daos.memory;

import java.util.HashMap;
import java.util.Iterator;

import es.upm.miw.apiSport.daos.DaoFactory;
import es.upm.miw.apiSport.daos.SportDao;
import es.upm.miw.apiSport.entities.Sport;

public class SportDaoMemory extends GenericMemoryDao<Sport> implements SportDao{

	public SportDaoMemory() {
		this.setMap(new HashMap<Integer, Sport>());
	}
	
	@Override
	protected Integer getId(Sport entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Sport entity, Integer id) {
		entity.setId(id);
	}

	@Override
	public Sport getSport(String name) {
		
		Iterator<Sport> sports=this.findAll().iterator();
		Sport sport=null;
		
		while(sports.hasNext()){
			sport=sports.next();
			if(sport.getName().equals(name)){
				return sport;
			}
		}
		
		return null;
	}

}
