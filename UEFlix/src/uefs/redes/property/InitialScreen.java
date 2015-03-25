package uefs.redes.property;

import java.util.ArrayList;
import java.util.List;

import uefs.redes.model.MovieInformation;

public class InitialScreen {

	private static List<MovieInformation> sameMovies  = new ArrayList<MovieInformation>();
	
	public void addMovies(MovieInformation... ms) {
		for (MovieInformation m : ms)
			sameMovies.add(m);
	}
	
	public List<MovieInformation> getMovies() {
		return sameMovies;
	}
}
