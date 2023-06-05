package dao;

import exception.DAOException;
import model.Address;
import model.Cinema;
import model.City;
import model.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDao {

    public List<State> getState() throws DAOException {
        List<State> states = new ArrayList<>();
        try {
            Statement statement = DBConnection.getInstance().getDBConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * FROM state");

            while (resultSet.next()) {
               State state=new State();
                state.setStateId(resultSet.getInt(1));
                state.setStateName(resultSet.getString(2));
                states.add(state);
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving address details", e);
        }

        return states;
    }

    public List<City> getCity(int state_id) throws DAOException {
        List<City> cities= new ArrayList<>();
        try {
            String sql = "select * FROM city where state_id=?";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, state_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                City city=new City();
                city.setCityId(resultSet.getInt(1));
                city.setCityName(resultSet.getString(2));
                city.setStateId(resultSet.getInt(3));
                cities.add(city);
            }
        } catch (SQLException e) {
            throw new DAOException("Error while retrieving address details", e);
        }

        return cities;
    }


    public Address getAddress(Cinema cinema) throws DAOException {
        Address address=new Address();
        try {
            String sql = "select * FROM address";

            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                address.setAddress_id(resultSet.getInt(1));
            }
            return address;
        } catch (SQLException e) {
            throw new DAOException("Error retrieving  details", e);
        }
    }

    public Address addAddress(Address address,int id) throws DAOException {
        try {
            PreparedStatement statement = null;
            String sql = "insert into address(address_line,city_id,pincode) values (?,?,?)";
            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setString(1, address.getAddress_line());
            statement.setInt(2, id);
            statement.setInt(3, address.getPincode());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("something went wrong ", ex);
        } catch (Exception ex) {
            throw new DAOException("something went wrong ", ex);
        }
        return address;
    }
}
