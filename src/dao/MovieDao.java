package dao;

import exception.DAOException;
import model.Cinema;
import model.Movie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


        public List<Movie> getMovies() throws DAOException {
            List<Movie> movies = new ArrayList<>();
            try {
                String sql = "SELECT * FROM movie";
                PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Movie movie = new Movie();
                    movie.setTitle(resultSet.getString("title"));
                    movie.setDuration(resultSet.getInt("duration"));
                    movie.setReleasedDate(resultSet.getString("released_date"));
                    movie.setDirectorName(resultSet.getString("director_name"));
                    movie.setProducerName(resultSet.getString("producer_name"));
                    movie.setMovieCategory(resultSet.getString("movie_category"));
                    movie.setLanguage(resultSet.getString("language"));
                    movies.add(movie);
                }
            } catch (SQLException e) {
                throw new DAOException("Error while retrieving movie details", e);
            }

            return movies;
        }


//    public static List<Movie> getMoviesByCityId(int cityId) throws DAOException {
//        List<Movie> movies = new ArrayList<>();
//        Movie movie=new Movie();
//        try
//        {
//            String sql = "SELECT m.* FROM movie m INNER JOIN cinema c ON m.cinema_id = c.id " +
//                    "JOIN address a ON a.address_id=c.address_id JOIN" +
//                    " city ci ON ci.city_id=a.city_id WHERE ci.city_id = ?";
//            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
//            statement.setInt(1, cityId);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                movie.setTitle(resultSet.getString("title"));
//                movie.setDuration(resultSet.getInt("duration"));
//                movie.setReleasedDate(resultSet.getString("released_date"));
//                movie.setDirectorName(resultSet.getString("director_name"));
//                movie.setProducerName(resultSet.getString("producer_name"));
//                movie.setMovieCategory(resultSet.getString("movie_category"));
//                movie.setLanguage(resultSet.getString("language"));
//                movies.add(movie);
//            }
//        }
//        catch (SQLException e) {
//            throw new DAOException("Error retrieving cinema details", e);
//        }
//        return movies;
//    }
    }
//    public List<Movie> getMovies(String genre) throws DAOException {
//        List<Movie> movies = new ArrayList<>();
//        try {
//            String sql = "SELECT * FROM movies WHERE genre=?";
//            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
//            statement.setString(1, genre);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Movie movie = new Movie();
//                movie.setTitle(resultSet.getString("title"));
//                movie.setGenre(resultSet.getString("genre"));
//                movie.setYear(resultSet.getInt("year"));
//                movies.add(movie);
//            }
//        } catch (SQLException e) {
//            throw new DAOException("Error while retrieving movie details by genre", e);
//        }
//
//        return movies;
//


