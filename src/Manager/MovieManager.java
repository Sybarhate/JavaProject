package Manager;

import dao.MovieDao;
import exception.DAOException;
import model.Cinema;
import model.Movie;
import view.MovieView;

public class MovieManager {
    public void movieDetails() throws DAOException {
    MovieView movieView=new MovieView();
    MovieDao movieDao=new MovieDao();
    Movie movie=movieView.takeMovieDetails();
    CinemaManager cinemaManager=new CinemaManager();
     Cinema cinema=cinemaManager.cinemaId();
    movieDao.addMovie(movie,cinema);
    }
}
