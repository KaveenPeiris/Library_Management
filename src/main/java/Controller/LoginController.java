package Controllers.Login;

public class LoginController {
    // Made static here:
    public static boolean checkUserNameAndPassword(String userName, String password) {
        return userName.equals("Kaveen") && password.equals("12345");
    }
}