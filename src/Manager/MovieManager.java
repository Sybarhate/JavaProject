package Manager;

import dao.MovieDao;
import exception.DAOException;
import model.Cinema;
import model.Movie;
import view.MovieView;

import java.util.List;

public class MovieManager {
   private MovieView movieView=new MovieView();
   private MovieDao movieDao=new MovieDao();
    public void movieDetails() throws DAOException {
    Movie movie=movieView.takeMovieDetails();
    CinemaManager cinemaManager=new CinemaManager();
     Cinema cinema=cinemaManager.cinemaId();
    movieDao.addMovie(movie,cinema);
    }

    public void listOfMovieDetails() throws DAOException {
        List<Movie> movies=movieDao.getMovies();
        movieView.displayMovieList(movies);
        movieView.takeMovieId();
    }

}
