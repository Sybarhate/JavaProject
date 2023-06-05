package common;
import model.Cinema;
import model.User;

public class Session {
    private static User currentUser=null;
    private static Cinema currentinemaId=null;

    public static Cinema getCurrentinemaId() {
        return currentinemaId;
    }

    public static void setCurrentinemaId(Cinema currentinemaId) {
        Session.currentinemaId = currentinemaId;
    }

    public static User getCurrentUser() {return currentUser;}

    public static void setCurrentUser(User currentUser) {Session.currentUser = currentUser;}



    //    public boolean isCinemaAdmin() {
//        return currentUser.getRoleId() == AppConstant.ROLE_CINEMA_USER;
//    }
}
