package es.upm.miw.apiSport.daos.memory;

import es.upm.miw.apiSport.daos.DaoFactory;
import es.upm.miw.apiSport.daos.SportDao;
import es.upm.miw.apiSport.daos.UserDao;

public class DaoFactoryMemory extends DaoFactory {

	private UserDao userDao;
	private SportDao sportDao;

	public DaoFactoryMemory() {
	}

	@Override
	public UserDao getUserDao() {
		if (userDao == null) {
			userDao = new UserDaoMemory();
		}
		return userDao;
	}

	@Override
	public SportDao getSportDao() {
		if (sportDao == null) {
			sportDao = new SportDaoMemory();
		}
		return sportDao;
	}

}
