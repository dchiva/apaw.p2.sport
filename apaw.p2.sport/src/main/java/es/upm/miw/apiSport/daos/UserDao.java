package es.upm.miw.apiSport.daos;

import java.util.List;

import es.upm.miw.apiSport.entities.Sport;
import es.upm.miw.apiSport.entities.User;

public interface UserDao extends GenericDao<User,Integer>{
	
	List<Sport> getSports(User user);
	
	void addSport(User user, Sport sport);
	
	User getUser(String name);
	
	boolean containsSport(User user, Sport sport);
}
