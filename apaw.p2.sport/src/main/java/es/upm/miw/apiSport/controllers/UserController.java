package es.upm.miw.apiSport.controllers;

import java.util.Iterator;
import java.util.List;

import es.upm.miw.apiSport.daos.DaoFactory;
import es.upm.miw.apiSport.entities.Sport;
import es.upm.miw.apiSport.entities.User;
import es.upm.miw.apiSport.wrappers.UsersWrapper;

public class UserController {

	public boolean createUser(String nick, String email){
		User user=DaoFactory.getFactory().getUserDao().getUser(nick);
		if(user==null){
			DaoFactory.getFactory().getUserDao().create(new User(nick,email));
			return true;
		}
		return false;
	}
	
	public boolean addUserSport(String userNick, String sportName){
		
		User user=DaoFactory.getFactory().getUserDao().getUser(userNick);
		Sport sport=DaoFactory.getFactory().getSportDao().getSport(sportName);
		
		if(user!=null && sport!=null && !DaoFactory.getFactory().getUserDao().containsSport(user, sport)){
			DaoFactory.getFactory().getUserDao().addSport(user, sport);
			return true;
		}
		return false;
	}
	
	public UsersWrapper getUsers(){
		UsersWrapper usersWrapper=new UsersWrapper();
		Iterator<User> users=DaoFactory.getFactory().getUserDao().findAll().iterator();
		User user=null;
		while(users.hasNext()){
			user=users.next();
			usersWrapper.addUser(user.getName(), user.getEmail());
		}
		
		return usersWrapper;
	}
	
	public UsersWrapper getUsersBySport(String sportName){
		UsersWrapper usersWrapper=new UsersWrapper();
		Sport sport=DaoFactory.getFactory().getSportDao().getSport(sportName);
		if(sport!=null){
			Iterator<User> users=DaoFactory.getFactory().getUserDao().findAll().iterator();
			User user=null;
			while(users.hasNext()){
				user=users.next();
				if(DaoFactory.getFactory().getUserDao().containsSport(user, sport)){
					usersWrapper.addUser(user.getName(), user.getEmail());
				}
			}
		}
		return usersWrapper;
	}
}
