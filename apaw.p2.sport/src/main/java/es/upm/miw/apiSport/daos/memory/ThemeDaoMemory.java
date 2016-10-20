package es.upm.miw.apiSport.daos.memory;

import java.util.HashMap;

import es.upm.miw.apiSport.daos.ThemeDao;
import es.upm.miw.apiSport.entities.Theme;

public class ThemeDaoMemory extends GenericMemoryDao<Theme> implements ThemeDao {

	public ThemeDaoMemory() {
		this.setMap(new HashMap<Integer, Theme>());
	}

	@Override
	protected Integer getId(Theme entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Theme entity, Integer id) {
		entity.setId(id);

	}

}