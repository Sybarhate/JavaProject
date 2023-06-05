package view;

import common.MenuHandler;
import model.Address;
import model.City;
import model.State;

import java.util.List;

public class AddressView {
    Address address = new Address();

//    public int displayState() {
//        System.out.println("Enter State id");
//        address.setState_id(MenuHandler.getNumberInput());
//        return address.getState_id();
//    }
//
//    public int displayCity() {
//        System.out.println("Enter city id");
//        address.setCity_id(MenuHandler.getNumberInput());
//        return address.getCity_id();
//    }
//
//    public Address displayAddress() {
//        System.out.print("Enter address line : ");
//        address.setAddress_line(MenuHandler.takeStringInput());
//        System.out.println("Enter pin code");
//        address.setPincode(MenuHandler.getNumberInput());
//        return address;
//    }

    public void displayStateDetails(List<State> states) {
        for (State state : states) {
            System.out.println("State ID: " + state.getStateId());
            System.out.println("State Name: " + state.getStateName());
            System.out.println("------------------------");
        }
    }
//    public static void stateDisplayDetails(List<Address>addresses) {
//        System.out.println("-------------------------------------------------------------------------------------");
//        System.out.printf("| %-15s | %-15s |\n", "state id", "Name");
//        System.out.println("--------------------------------------------------------------------------------------");
//        for (Address address : addresses) {
//        System.out.printf("| %-16s | %-20s |\n", address.getState_id(),address.getState_name());
//        System.out.println("-------------------------------------------------------------------------------------");
//    }
//    }

    public void cityDisplayDetails(List<City> cities) {
        for (City city : cities) {
            System.out.println("City ID: " + city.getCityId());
            System.out.println("City Name: " + city.getCityName());
            System.out.println("------------------------");
        }
    }

    public void addressDiaplayDetails(Address address) {
        System.out.println("Address ID: " + address.getAddress_id());
        System.out.println("Address line: " + address.getAddress_line());
        System.out.println("Pincode: " + address.getPincode());
        System.out.println("------------------------");
    }
}
