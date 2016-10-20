package es.upm.miw.apiSport.api;

import es.upm.miw.apiSport.controllers.VoteController;
import es.upm.miw.apiSport.exceptions.InvalidVoteException;
import es.upm.miw.apiSport.exceptions.NotFoundThemeIdException;
import es.upm.miw.apiSport.wrappers.VoteListWrapper;

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
