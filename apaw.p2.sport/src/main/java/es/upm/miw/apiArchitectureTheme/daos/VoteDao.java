package es.upm.miw.apiArchitectureTheme.daos;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.entities.Vote;

public interface VoteDao extends GenericDao<Vote, Integer> {
	List<Integer> findValueByThemeId(int themeId);
}
