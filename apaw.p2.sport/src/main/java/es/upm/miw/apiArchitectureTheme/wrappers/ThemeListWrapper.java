package es.upm.miw.apiArchitectureTheme.wrappers;

import java.util.ArrayList;
import java.util.List;

public class ThemeListWrapper {
	List<ThemeWrapper> themeList;

	
	public ThemeListWrapper() {
		themeList = new ArrayList<>();
	}

	public List<ThemeWrapper> getThemeList() {
		return themeList;
	}

	public void addThemeWrapper(ThemeWrapper themeWrapper){
		themeList.add(themeWrapper);
	}
	

	@Override
	public String toString() {
		String result = "{\"themeList\":[ ";
		for (ThemeWrapper themeWrapper : themeList) {
			result += themeWrapper.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}
}
