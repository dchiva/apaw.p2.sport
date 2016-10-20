package es.upm.miw.apiSport.daos;

import java.util.List;

import es.upm.miw.apiSport.entities.Vote;

public interface VoteDao extends GenericDao<Vote, Integer> {
	List<Integer> findValueByThemeId(int themeId);
}
