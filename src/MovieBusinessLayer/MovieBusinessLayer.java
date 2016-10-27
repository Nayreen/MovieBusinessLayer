package MovieBusinessLayer;

import java.util.ArrayList;
import java.util.List;
import MovieDataLayer.*;
import MovieClassLayer.*;
public class MovieBusinessLayer {


	Films CompleteList = new Films();
	public Films GetFilmsFromCSV(String csvPath) 
	{
		MovieClassLayer.Films films = MovieDataLayer.GetCsvData(csvPath);
		CompleteList = films;

		return films;

	}


	public List<Director> GetDistinctDirectorsFromFilms(Films films, String directorID)
	{
		// Gets the List of Directors from the Films class
		// It receives DirectorID and the List of films	

		List<Director> Result = new ArrayList();



		//Gets the list of actors from the Films class. It receives the Actor ID and list of films.
		films.getFilms().stream().forEach((a) -> {
			a.Directors.stream().filter((A) -> (A.DirectorID.equalsIgnoreCase(directorID))).forEach((A) -> {
				Result.add(A);
			});
		});


		return Result;
	}



	public List<Actor> GetDistinctActorsFromFilms(Films films, String actorID)
	{
		List<Actor> Result = new ArrayList();
		//Gets the list of actors from the Films class. It receives the Actor ID and list of films.

		films.getFilms().stream().forEach((a) -> {
			a.Actors.stream().filter((A) -> (A.ActorID.equalsIgnoreCase(actorID))).forEach((A) -> {
				Result.add(A);
			});
		});
		return Result;
	}



	public List<SimplisticFilm> GetDistinctSimplisticFilmFromFilms(Films films, String filmID)
	{
		//this will be used for the drop-down list.
		//this will only get the FilmID and FilmName
		//this method will receive Films and FilmID
		List<SimplisticFilm> Result = new ArrayList();

		films.getFilms().stream().filter((f) -> (f.FilmID.equalsIgnoreCase(filmID))).map((f) -> new SimplisticFilm(f.FilmID, f.FilmName)).forEach((e) -> {
			Result.add(e);
		});
		return Result;
	}



	public Films GetFilmsSubset(String filmID, String directorID, String actorID, Films films)
	{
		//This method will use GetFilmSubsetByMovieID, GetFilmSubsetByDirectorID and GetFilmSubsetByActorID
		//Search for list of films in Films class using filmId, directorId and actorID.
		//returns the film from the list related to its FilmID, DirectorID and ActorID


		return null;
	}


	public Films GetFilmSubsetByMovieID(Films films, String filmID)
	{

		//this method is used to filter out the movies using the FilmID provided
		//it will receive the full list of films and the FilmID
		//this will return the list of films which matches with their FilmID 
		List<Film> f = new ArrayList();

		films.getFilms().stream().filter((F) -> (F.FilmID.equalsIgnoreCase(filmID))).forEachOrdered((F) -> {
			f.add(F);
		});

		return (Films) f;
	}



	public Films GetFilmSubsetByDirectorID(Films films, String directorID)
	{

		//this method is used to filter out the movies using the DirectorID provided
		//it will receive the full list of films and the DirectorID
		//this will return the list of films which matches with their DirectorID 
		List<Film> f = new ArrayList();

		films.getFilms().forEach((F) -> {
			F.Directors.stream().filter((D) -> (D.DirectorID.equals(directorID))).forEachOrdered((_item) -> {
				f.add(F);
			});
		});

		return (Films) f;

	}



	public Films GetFilmSubsetByActorID(Films films, String actorID)
	{

		//this method is used to filter out the movies using the ActorID provided
		//it will receive the full list of films and the ActorID
		//this will return the list of films which matches with their ActorID 
		List<Film> f = new ArrayList();

		films.getFilms().forEach((F) -> {
			F.Actors.stream().filter((A) -> (A.ActorID.equals(actorID))).forEachOrdered((_item) -> {
				f.add(F);
			});
		});


		return (Films) f;
	}


}

