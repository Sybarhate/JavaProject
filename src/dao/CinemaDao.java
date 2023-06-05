package dao;

import exception.DAOException;
import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CinemaDao {
//    Address address = new Address();
//
//    public Cinema allCinemaDetails(String name) throws DAOException {
//        Cinema cinema = new Cinema();
//        try {
//            String sql = "SELECT name FROM cinema where name=?";
//            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
//            statement.setString(1, name);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                cinema.setName(resultSet.getString(1));
//
//            }
//        } catch (SQLException e) {
//            throw new DAOException("Error retrieving cinema details", e);
//        }
//        return cinema;
//    }

    public List<Cinema> getCinemaDetails(int id) throws DAOException {
        List<Cinema> cinemas = new ArrayList<>();
        try {
            String sql = ("SELECT c.id, c.name, a.address_id, a.address_line, a.pincode, ci.city_id, ci.city_name AS city_name, s.state_id, s.state_name AS state_name\n" +
                    "FROM cinema c\n" +
                    "INNER JOIN address a ON c.address_id = a.address_id\n" +
                    "INNER JOIN city ci ON a.city_id = ci.city_id\n" +
                    "INNER JOIN state s ON ci.state_id = s.state_id\n" +
                    "WHERE c.user_id= ?");
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cinema cinema = new Cinema();
                cinema.setId(resultSet.getInt(1));
                cinema.setName(resultSet.getString(2));

                Address address = new Address(resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5));
                cinema.setAddress(address);

                State state = new State(resultSet.getInt(8), resultSet.getString(9));
                cinema.setState(state);

                City city = new City(resultSet.getInt(6), resultSet.getString(7));
                cinema.setCity(city);
                cinemas.add(cinema);
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving cinema details", e);
        }
        return cinemas;
    }


//    public void addCinema(Cinema cinema1) throws DAOException {
//        try {
//            PreparedStatement statement = null;
////            String sql = "insert into cinema1(name,location,no_of_screen,no_of_seats) " +
////                    "values (?,?,?,?)";
//            String sql = "insert into cinema(name,location,no_of_screen,no_of_seats) " +
//                    "values (?,?,?,?)";
//            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
//            statement.setString(1, cinema1.getName());
//            statement.setString(2, cinema1.getLocation());
//            statement.setInt(3, cinema1.getNo_of_screen());
//            statement.setInt(4, cinema1.getNo_of_seats());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new DAOException("Something went wrong", e);
//        }
//    }

    public void addCinema(Cinema cinema1, int addressId, int userId) throws DAOException {
        try {

            PreparedStatement statement = null;
            String sql = "insert into cinema(name,address_id,user_id) values (?,?,?)";
            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setString(1, cinema1.getName());
            statement.setInt(2, addressId);
            statement.setInt(3, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Something went wrong", e);
        }
    }

    public Cinema getCinemaId(int userId) throws DAOException {
        Cinema cinema = new Cinema();
        try {
            String sql = "select id FROM cinema where user_id=?";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
           statement.setInt(1,userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cinema.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving cinema ID", e);
        }
        return cinema;
    }
}

//    public Cinema getCinemaId() throws DAOException {
//        Cinema cinema=new Cinema();
//        try {
//            String sql="select id FROM cinema order by id desc LIMIT 1";
//            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                cinema.setId(resultSet.getInt(1));
//            }
//        } catch (SQLException e) {
//            throw new DAOException("Error retrieving cinema ID", e);
//        }
//        return cinema;
//    }


