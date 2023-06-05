package dao;

import exception.DAOException;
import model.Screen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScreenDao {

    public void addScreenData(int cinemaId,int rows,int columns) throws DAOException {
        try {

            PreparedStatement statement = null;
            String sql = "insert into screen(cinema_id,no_of_rows,no_of_columns) values (?,?,?)";
            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setInt(1, cinemaId);
            statement.setInt(2, rows);
            statement.setInt(3, columns);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Something went wrong", e);
        }
    }
    public Screen getScreenData() throws DAOException {
        Screen screen=new Screen();
        try {

            String sql = "SELECT id,cinema_id,no_of_rows,no_of_columns FROM screen";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                screen.setScreenId(resultSet.getInt(1));
                screen.setCinemaId(resultSet.getInt(2));
                screen.setNoOfRows(resultSet.getInt(3));
                screen.setNoOfColumns(resultSet.getInt(4));

            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving screen details", e);
        }
        return screen;
    }
}
