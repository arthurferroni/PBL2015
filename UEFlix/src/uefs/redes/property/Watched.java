package uefs.redes.property;


import java.util.ArrayList;
import java.util.List;

import uefs.redes.model.*;

public class Watched {
	
	private static List<MovieInformation> favorites = new ArrayList<MovieInformation>();
		
	public void addMovies(MovieInformation... ms) {
		for (MovieInformation m : ms)
			favorites.add(m);
	}
	
	public List<MovieInformation> getMovies() {
		return favorites;
	}
	
	
		
}
