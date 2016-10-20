package es.upm.miw.apiArchitectureTheme;

import es.upm.miw.apiArchitectureTheme.api.ThemeResource;
import es.upm.miw.apiArchitectureTheme.api.VoteResource;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidRequestException;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidThemeFieldException;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;

public class Dispatcher {

	private ThemeResource themeResource = new ThemeResource();
	private VoteResource voteResource = new VoteResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		// **/themes
		if ("themes".equals(request.getPath())) {
			response.setBody(themeResource.themeList().toString());
			// **/themes/{id}/overage
		} else if ("themes".equals(request.paths()[0]) && "overage".equals(request.paths()[2])) {
			try {
				response.setBody(themeResource.themeOverage(Integer.valueOf(request.paths()[1])).toString());
			} catch (Exception e) {
				responseError(response, e);
			}
			// **/votes
		} else if ("votes".equals(request.getPath())) {
			response.setBody(voteResource.voteList().toString());
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		// POST **/themes body="themeName"
		case "themes":
			// Injectar parámetros...
			try {
				themeResource.createTheme(request.getBody());
				response.setStatus(HttpStatus.CREATED);
			} catch (InvalidThemeFieldException e) {
				this.responseError(response, e);
			}
			break;
		// POST votes body="themeId:vote"
		case "votes":
			String themeId = request.getBody().split(":")[0];
			String vote = request.getBody().split(":")[1];
			try {
				voteResource.createVote(Integer.valueOf(themeId), Integer.valueOf(vote));
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				responseError(response, e);
			}
			break;
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
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
