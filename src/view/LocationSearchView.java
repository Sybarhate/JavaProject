package view;

import common.MenuHandler;
import exception.DAOException;
import model.City;
import model.State;
import dao.AddressDao;
import java.util.List;

public class LocationSearchView {

    AddressDao addressDao=new AddressDao();
    AddressView addressView=new AddressView();

    public int takeLocation() throws DAOException {
        System.out.println("Please Select State ");
        List<State> stateList = addressDao.getState();
        addressView.displayStateDetails(stateList);
        System.out.print("Enter State Id ");
        int stateId = (MenuHandler.getNumberInput());
        State state = new State();
        state.setStateId(stateId);

        System.out.println("Please Select City ");
        List<City> cityList = addressDao.getCity(stateId);
        addressView.cityDisplayDetails(cityList);
        System.out.print("Enter City Id ");
        int cityId = (MenuHandler.getNumberInput());
        City city=new City();
        city.setCityId(cityId);
        return cityId;
    }
}
