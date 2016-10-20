package es.upm.miw.apiSport.daos.memory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import es.upm.miw.apiSport.daos.DaoFactory;
import es.upm.miw.apiSport.daos.UserDao;
import es.upm.miw.apiSport.entities.Sport;
import es.upm.miw.apiSport.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao{

	public UserDaoMemory() {
		this.setMap(new HashMap<Integer, User>());
	}
	
	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}

	@Override
	protected void setId(User entity, Integer id) {
		entity.setId(id);
	}

	@Override
	public List<Sport> getSports(User user) {
		return user.getSports();
	}

	@Override
	public void addSport(User user, Sport sport) {
		user.addSport(sport);
	}

	@Override
	public User getUser(String name) {
		
		Iterator<User> users=this.findAll().iterator();
		User user=null;
		
		while(users.hasNext()){
			user=users.next();
			if(user.getName().equals(name)){
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean containsSport(User user, Sport sport) {
		
		Iterator<Sport> sportsUser=user.getSports().iterator();
		while(sportsUser.hasNext()){
			if(sportsUser.next().getName().equals(sport.getName())){
				return true;
			}
		}
		return false;
	}

}
