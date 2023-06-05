package Manager;

import common.Session;
import constant.AppConstant;
import exception.DAOException;
import operations.Operations;
import view.LocationSearchView;

public class RoleManager {

    public void checkRole() throws DAOException {
        if (Session.getCurrentUser().getRoleId() == AppConstant.ROLE_SYSTEM_ADMIN) {
        } else if (Session.getCurrentUser().getRoleId() == AppConstant.ROLE_CINEMA_USER) {
            Operations operations = new Operations();
            operations.checkCinemaUserRoleOperations();
        } else if (Session.getCurrentUser().getRoleId() == AppConstant.ROLE_CUSTOMER) {
            LocationSearchView locationSearchView=new LocationSearchView();
            locationSearchView.takeLocation();

        }
    }
}
