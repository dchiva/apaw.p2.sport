package es.upm.miw.apiSport.wrappers;

public class UserWrapper {
	
	private String name;
	private String email;
	
	public UserWrapper(){}
	
	public UserWrapper(String name, String email){
		this.name=name;
		this.email=email;
	}
	
	@Override
	public String toString() {
		return "{\"nombre\":" + this.name + ",\"email\":\"" + this.email + "\"}";
	}
}
