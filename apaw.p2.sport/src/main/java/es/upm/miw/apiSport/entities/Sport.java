package es.upm.miw.apiSport.entities;

public class Sport {

	private int id;
	private String name;
	
	public Sport(){}
	
	public Sport(String name){
		this.name=name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}
}
