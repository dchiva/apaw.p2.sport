package es.upm.miw.apiSport.wrappers;

import java.util.ArrayList;
import java.util.List;

public class UsersWrapper {

	List<UserWrapper> users;
	
	public UsersWrapper(){
		this.users=new ArrayList<UserWrapper>();
	}
	
	public void addUserWrapper(UserWrapper user){
		users.add(user);
	}
	
	public void addUser(String name, String email){
		this.addUserWrapper(new UserWrapper(name, email));
	}
	
	@Override
	public String toString() {
		String result = "{\"users\":[ ";
		for (UserWrapper user : this.users) {
			result += user.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}
}
