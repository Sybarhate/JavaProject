package view;

import common.MenuHandler;
import model.Movie;

import java.util.List;

public class MovieView {
    Movie movie=new Movie();
    public Movie takeMovieDetails()
    {
        System.out.println("Enter movie title ");
        movie.setTitle(MenuHandler.takeStringInput());
        System.out.println("Enter Duration ");
        movie.setDuration(MenuHandler.getNumberInput());
        System.out.println("Enter released date ");
        movie.setReleasedDate(MenuHandler.takeStringInput());
        System.out.println("Enter director name ");
        movie.setDirectorName(MenuHandler.takeStringInput());
        System.out.println("Enter producer name ");
        movie.setProducerName(MenuHandler.takeStringInput());
        System.out.println("Enter movie category ");
        movie.setMovieCategory(MenuHandler.takeStringInput());
        System.out.println("Enter Language ");
        movie.setLanguage(MenuHandler.takeStringInput());
        return movie;
    }

    public void displayMovieList(List<Movie>movies)
    {
        System.out.println("List of Movies:");
        System.out.println("----------------");

        for (Movie movie : movies) {
            System.out.println("Title: " + movie.getTitle());
            System.out.println("Duration: " + movie.getDuration());
            System.out.println("Released Date: " + movie.getReleasedDate());
            System.out.println("Director: " + movie.getDirectorName());
            System.out.println("Producer: " + movie.getProducerName());
            System.out.println("Category: " + movie.getMovieCategory());
            System.out.println("Language: " + movie.getLanguage());
            System.out.println("----------------");
        }
    }
    public int takeMovieId()
    {
        System.out.println("Enter movie id ");
        movie.setId(MenuHandler.getNumberInput());
        return movie.getId();
    }
}
