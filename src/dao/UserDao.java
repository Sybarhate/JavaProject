package dao;

import exception.DAOException;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public void createUser(User user) throws DAOException {
        try {
            PreparedStatement statement = null;
            String sql = "insert into user(first_name,last_name,email_address,mobile_number,date_of_birth,gender,address," +
                    "password,verification_code,is_verified,role_id) values (?,?,?,?,?,?,?,?,?,?,?)";
            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getMobileNumber());
            statement.setString(5, user.getDateOfBirth());
            statement.setString(6, user.getGender());
            statement.setString(7, user.getAddress());
            statement.setString(8, user.getPassword());
            statement.setString(9, user.getVerificationCode());
            statement.setBoolean(10, user.isVerified());
            statement.setInt(11, user.getRoleId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("", ex);
        } catch (Exception ex) {
            throw new DAOException("something went wrong ", ex);
        }
    }

    public User checkUserCredential(String emailId, String password) throws DAOException {
        User user = null;
        try {
            //String sql = "SELECT * FROM user WHERE Email_address= ? AND Password = ?";
            String sql = "select * from user u join role r on u.role_id=r.id where email_address=? and password=? ";
            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setString(1, emailId);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getInt(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setMobileNumber(resultSet.getString(5));
                user.setDateOfBirth(resultSet.getString(6));
                user.setGender(resultSet.getString(7));
                user.setAddress(resultSet.getString(8));
                user.setPassword(resultSet.getString(9));
                user.setVerificationCode(resultSet.getString(10));
                user.setVerified(resultSet.getBoolean(11));
                user.setRoleId(resultSet.getInt(12));
                user.setRole_name(resultSet.getString("role_name"));
            }
            return user;
        } catch (SQLException ex) {
            throw new DAOException("something went wrong ", ex);
        }
    }

    public boolean isEmailExists(String emailToCheck) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT Email_Address FROM user WHERE Email_Address = ?";
            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setString(1, emailToCheck);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("something went wrong ", e);
        } catch (Exception ex) {
            throw new DAOException("something went wrong ", ex);
        }
        return false;
    }

    public boolean isMobileExists(String mobileToCheck) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean emailExists = false;
        try {
            String sql = "SELECT Mobile_Number FROM user WHERE Mobile_Number = ?";
            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setString(1, mobileToCheck);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("something went wrong ", e);
        } catch (Exception ex) {
            throw new DAOException("something went wrong ", ex);
        }
        return emailExists;
    }

    public void updateUserIsVerified(boolean isVerified, String email) throws DAOException {
        try {
            String sql = " UPDATE user SET is_Verified= ? WHERE  Email_Address= ?";
            PreparedStatement statement = null;
            statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
            statement.setBoolean(1, isVerified);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("something went wrong ", e);
        } catch (Exception ex) {
            throw new DAOException("something went wrong ", ex);
        }
    }

//    public void updateRoleById(int roleid, String email) throws DAOException {
//        try {
//            String sql = " UPDATE user SET role_id= ? WHERE  Email_Address= ?";
//            PreparedStatement statement = DBConnection.getInstance().getDBConnection().prepareStatement(sql);
//            statement.setInt(1, roleid);
//            statement.setString(2, email);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new DAOException("something went wrong ", e);
//        } catch (Exception ex) {
//            throw new DAOException("something went wrong ", ex);
//        }
//    }
}
