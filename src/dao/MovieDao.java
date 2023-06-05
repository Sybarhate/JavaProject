package dao;

import exception.DAOException;
import model.Cinema;
import model.Movie;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieDao {
    public void addMovie(Movie movie, Cinema cinema) throws DAOException {
        try {
            PreparedStatement statement = null;
            String sql = "insert into movie(title,duration,released_date,director_name,producer_name,movie_category,language,cinema_id) values (?,?,?,?,?,?,?,?)";
            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setString(1, movie.getTitle());
            statement.setInt(2, movie.getDuration());
            statement.setString(3, movie.getReleasedDate());
            statement.setString(4, movie.getDirectorName());
            statement.setString(5, movie.getProducerName());
            statement.setString(6, movie.getMovieCategory());
            statement.setString(7, movie.getLanguage());
            statement.setInt(8,cinema.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Something went wrong", e);
        }
    }

//    public void getMovieDetails(cinema id,city)
//    {
//
//    }
}
