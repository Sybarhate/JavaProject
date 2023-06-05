package Manager;

import dao.AddressDao;
import exception.DAOException;
import model.Address;

public class AddressManager {
    private AddressDao addressDao = new AddressDao();

    public int getAddressDetails() throws DAOException {
        CinemaManager cinemaManager=new CinemaManager();
        Address address = addressDao.getAddress(cinemaManager.cinemaId());
        return address.getAddress_id();
    }

}

