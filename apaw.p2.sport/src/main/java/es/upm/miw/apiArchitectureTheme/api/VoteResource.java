package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.VoteController;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidVoteException;
import es.upm.miw.apiArchitectureTheme.exceptions.NotFoundThemeIdException;
import es.upm.miw.apiArchitectureTheme.wrappers.VoteListWrapper;

public class VoteResource {

	// POST **/votes   body="themeId:vote"
	public void createVote(int themeId, int vote) throws InvalidVoteException, NotFoundThemeIdException {
		if (vote < 0 || vote > 10) {
			throw new InvalidVoteException("" + vote);
		}
		if (!new VoteController().createVote(themeId, vote)) {
			throw new NotFoundThemeIdException("" + themeId);
		}
	}

	// GET **/votes
	public VoteListWrapper voteList() {
		return new VoteController().voteList();
	}

}
