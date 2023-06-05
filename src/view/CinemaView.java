package view;

import common.MenuHandler;
import dao.AddressDao;
import exception.DAOException;
import model.Address;
import model.Cinema;
import model.City;
import model.State;
import java.util.List;

public class CinemaView {

    private AddressDao addressDao = new AddressDao();
    private AddressView addressView = new AddressView();

    //addCinemaDetails
    public Cinema takeCinemaDetails() throws DAOException {
        Cinema cinema = new Cinema();
        System.out.print("Enter Cinema Name: ");
        cinema.setName(MenuHandler.takeStringInput());

        Address address = new Address();
        System.out.print("Enter address line : ");
        address.setAddress_line(MenuHandler.takeStringInput());
        System.out.println("Enter pin code");
        address.setPincode(MenuHandler.getNumberInput());

        List<State> stateList = addressDao.getState();
        addressView.displayStateDetails(stateList);
        System.out.print("Enter State Id ");
        int stateId = (MenuHandler.getNumberInput());
        State state = new State();
        state.setStateId(stateId);

        List<City> cityList = addressDao.getCity(stateId);
        addressView.cityDisplayDetails(cityList);
        System.out.print("Enter City Id  ");
        int cityId = (MenuHandler.getNumberInput());

        addressDao.addAddress(address, cityId);
        return cinema;
    }

//    public String takeCinemaName() {
//        System.out.print("Enter Cinema name : ");
//        String name = MenuHandler.takeStringInput();
//        return name;
//    }

    public int displayMenuList() {
        int choice;
        System.out.println("Welcome to Cinema Menu !");
        System.out.println("1. Add Cinema");//screen add and layout
        System.out.println("2. View All Cinema");
        System.out.println("3. Add Movie");
        System.out.println("4. Back ");
        System.out.println("5. Exit ");
        System.out.println("Enter your choice: ");
        choice = MenuHandler.getNumberInput();
        return choice;
    }

    //    public static void displayCinemas(List<Cinema> cinemas) {
//
//        System.out.println("-------------------------------------------------------------------------------");
//        System.out.printf("| %-20s | %-20s |\n", "Name of the Cinema", "Location of Cinema");
//        System.out.println("-------------------------------------------------------------------------------");
//
//        for (Cinema cinema : cinemas) {
//            System.out.println(cinema.getId());
//            System.out.printf("| %-20s | %-20s |\n", cinema.getName() );
//        }
//
//        System.out.println("-----------------------------------------------------------");
//    }
//
//    public static void displayCinemas(Cinema cinemas) {
//
//        System.out.println("-------------------------------------------------------------------------------");
//        System.out.printf("| %-20s | %-20s |\n", "Name of the Cinema", "Location of Cinema");
//        System.out.println("-------------------------------------------------------------------------------");
//
////    }
//    public static void displayAllCinema(Cinema cinema) {
//        System.out.println("-------------------------------------------------------------------------------------");
//        System.out.printf("| %-15s | %-15s | %-10s | %-10s |\n", "Name of the Cinema", "address Line", "pincode", "city name", "state Name");
//        System.out.println("--------------------------------------------------------------------------------------");
//        System.out.printf("| %-16s | %-20s | %-16d | %-20d |\n", cinema.getName());
//        System.out.println("-------------------------------------------------------------------------------------");
//    }

    public void printCinemaDetails(List<Cinema> cinemas) {
        for (Cinema cinema : cinemas) {
            System.out.println("Cinema ID: " + cinema.getId());
            System.out.println("Name: " + cinema.getName());
            System.out.println("Address Line: " + cinema.getAddress().getAddress_line());
            System.out.println("City ID: " + cinema.getCity().getCityId());
            System.out.println("City Name: " + cinema.getCity().getCityName());
            System.out.println("State ID: " + cinema.getState().getStateId());
            System.out.println("State Name: " + cinema.getState().getStateName());
            System.out.println("----------------------------------");
        }
    }


}





