package es.upm.miw.apiSport;

import es.upm.miw.apiSport.api.SportResource;
import es.upm.miw.apiSport.api.UserResource;
import es.upm.miw.apiSport.exceptions.InvalidRequestException;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;

public class Dispatcher {

	private UserResource userResource = new UserResource();
	private SportResource sportResource = new SportResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		// **/themes
		
		if ("users".equals(request.getPath())) {
			
			response.setBody(userResource.getUsers().toString());
			//response.setBody(themeResource.themeList().toString());
			// **/themes/{id}/overage
			
			
		} else if (request.paths().length==2 && "users".equals(request.paths()[0]) && request.paths()[1].indexOf("search")==0) {
			System.out.println("Entra en search");
			try{
				String[] parametersGET=request.paths()[1].split("[?]");
				String[] sportParameter=parametersGET[1].split("=");
				String sportName=sportParameter[1];
				response.setBody(userResource.getUsersBySport(sportName).toString());
			}catch(Exception e){
				e.printStackTrace();
				responseError(response, e);
			}
			/*try {
				response.setBody(themeResource.themeOverage(Integer.valueOf(request.paths()[1])).toString());
			} catch (Exception e) {
				responseError(response, e);
			}*/
			// **/votes
			
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
			
			case "users":
				try{
					String[] bodyParams=request.getBody().split(":");
					String nick=bodyParams[0];
					String email=bodyParams[1];
					userResource.createUser(nick, email);
					response.setBody("{\"succes\":\"Usuario creado correctamente\"}");
					response.setStatus(HttpStatus.CREATED);
				}catch(Exception e){
					this.responseError(response, e);
				}
				break;
				
			case "sports":
				try{
					String sportName=request.getBody();
					sportResource.createSport(sportName);
					response.setBody("{\"succes\":\"Deporte creado correctamente\"}");
					response.setStatus(HttpStatus.CREATED);
				}catch(Exception e){
					this.responseError(response, e);
				}
				break;
				
			default:
				responseError(response, new InvalidRequestException(request.getPath()));
				break;
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		if ("users".equals(request.paths()[0]) && "sport".equals(request.paths()[2])) {
			
			try {
				String userNick=request.paths()[1];
				String sportName=request.getBody();
				userResource.addUserSport(userNick, sportName);
				response.setBody("{\"succes\":\"Deporte añadido correctamente al usuario\"}");
				//response.setBody(themeResource.themeOverage(Integer.valueOf(request.paths()[1])).toString());
			} catch (Exception e) {
				responseError(response, e);
			}
			
		}else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
		
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
			default:
				responseError(response, new InvalidRequestException(request.getPath()));
				break;
		}
	}

}
