package es.upm.miw.apiSport.daos;

import es.upm.miw.apiSport.entities.Sport;

public interface SportDao extends GenericDao<Sport,Integer>{

	Sport getSport(String name);
}
