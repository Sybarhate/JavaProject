package Manager;

import common.Session;
import dao.CinemaDao;
import exception.DAOException;
import model.Cinema;
import view.CinemaView;

import java.util.List;

public class CinemaManager {
    private CinemaDao cinemaDao = new CinemaDao();
    private CinemaView cinemaView = new CinemaView();
    private AddressManager addressManager = new AddressManager();

    public void cinemaDetails() throws DAOException {
//        List<Cinema> cinemas = cinemaDao.cinemaDetails();
        List<Cinema> cinema = cinemaDao.getCinemaDetails(Session.getCurrentUser().getUserId());
        cinemaView.printCinemaDetails(cinema);

    }


    public Cinema cinemaId() throws DAOException {
    Cinema cinema=cinemaDao.getCinemaId(Session.getCurrentUser().getUserId());
    return cinema;
    }


//    public void allcinemaDetails() throws DAOException {
//        String name = cinemaView.takeCinemaName();
//        Cinema cinema = cinemaDao.allCinemaDetails(name);
//       // cinemaView.displayAllCinema(cinema);
//    }

    public void addCinemaDetails() throws DAOException {
        Cinema cinema = cinemaView.takeCinemaDetails();
        cinemaDao.addCinema(cinema, addressManager.getAddressDetails(), Session.getCurrentUser().getUserId());
    }

}
