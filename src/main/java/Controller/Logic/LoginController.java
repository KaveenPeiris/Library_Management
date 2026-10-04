package Controller.Logic;

public class LoginController {

    public static boolean checkUserNameAndPassword(String userName, String password) {
        if (userName == null || password == null) {
            return false;
        }
        return "Kaveen".equals(userName.trim()) && "12345".equals(password.trim());
    }
}