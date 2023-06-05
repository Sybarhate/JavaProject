package view;

import common.MenuHandler;
import model.Movie;

public class MovieView {
    public Movie takeMovieDetails()
    {
        Movie movie=new Movie();
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
}
