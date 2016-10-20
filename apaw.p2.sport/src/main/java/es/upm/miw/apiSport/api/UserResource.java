package es.upm.miw.apiSport.api;

import es.upm.miw.apiSport.controllers.SportController;
import es.upm.miw.apiSport.controllers.UserController;
import es.upm.miw.apiSport.daos.DaoFactory;
import es.upm.miw.apiSport.entities.Sport;
import es.upm.miw.apiSport.exceptions.ObjectAlreadyExist;
import es.upm.miw.apiSport.exceptions.ObjectNotExists;
import es.upm.miw.apiSport.wrappers.UsersWrapper;

public class UserResource {

	public void createUser(String nick, String email) throws ObjectAlreadyExist{
		UserController userController=new UserController();
		if(!userController.createUser(nick, email)){
			throw new ObjectAlreadyExist("Usuario "+nick+" ya existe");
		}
	}
	
	public void addUserSport(String userNick, String sportName) throws ObjectAlreadyExist, ObjectNotExists{
		UserController userController=new UserController();
		if(!userController.addUserSport(userNick, sportName)){
			if(! new SportController().existsSport(sportName)){
				throw new ObjectNotExists(sportName);
			}
			throw new ObjectAlreadyExist("Usuario "+userNick+" ya tiene el deporte "+sportName+" asociado");
		}
	}
	
	public UsersWrapper getUsers(){
		UserController userController=new UserController();
		return userController.getUsers();
	}
	
	public UsersWrapper getUsersBySport(String sportName){
		UserController userController=new UserController();
		return userController.getUsersBySport(sportName);
	}
}
