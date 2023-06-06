package model;

public class Address {

    private int address_id;
    private String address_line;
    private int pincode;
    private int state_id;
    private String state_name;
    private int city_id;
    private String city_name;

    public Address() {
    }

    public Address(int address_id, String address_line, int pincode) {
        this.address_id = address_id;
        this.address_line = address_line;
        this.pincode = pincode;
    }

    public Address(String address_line) {
        this.address_line = address_line;
    }
    public int getAddress_id() {return address_id;}

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress_line() {
        return address_line;
    }

    public void setAddress_line(String address_line) {
        this.address_line = address_line;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}
