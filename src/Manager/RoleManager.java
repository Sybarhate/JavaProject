package Manager;

import common.Session;
import constant.AppConstant;
import exception.DAOException;
import operations.Operations;
import view.LocationSearchView;

public class RoleManager {

    public void checkRole() throws DAOException {
        Operations operations = new Operations();
        if (Session.getCurrentUser().getRoleId() == AppConstant.ROLE_SYSTEM_ADMIN) {
        } else if (Session.getCurrentUser().getRoleId() == AppConstant.ROLE_CINEMA_USER) {
            operations.checkCinemaUserRoleOperations();
        } else if (Session.getCurrentUser().getRoleId() == AppConstant.ROLE_CUSTOMER) {
            operations.customerOperation();
//            LocationSearchView locationSearchView=new LocationSearchView();
//            locationSearchView.takeLocation();
//            MovieManager movieManager=new MovieManager();
//            movieManager.listOfMovieDetails();
//            CinemaManager cinemaManager=new CinemaManager();
//            cinemaManager.cinemaDetailsByCity();

        }
    }
}
