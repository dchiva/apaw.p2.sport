package es.upm.miw.apiArchitectureTheme.wrappers;

import java.util.ArrayList;
import java.util.List;

public class VoteListWrapper {
	List<VoteWrapper> voteList = new ArrayList<>();

	public VoteListWrapper() {
	}
	
	public List<VoteWrapper> getVoteList() {
		return voteList;
	}

	public void addVoteWrapper(VoteWrapper voteWrapper) {
		voteList.add(voteWrapper);
	}

	@Override
	public String toString() {
		String result = "{\"voteList\":[ ";
		for (VoteWrapper voteWrapper : voteList) {
			result += voteWrapper.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}

}
