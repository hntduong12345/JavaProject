package sample.utils;

public class Tools {
    public static boolean checkPasswordFormat(String password){
        return password.matches(".*[a-zA-Z]+.*") &&
               password.matches(".*[\\d]+.*") &&
               password.matches(".*[\\W]+.*");
    }
    
    public static boolean checkEmailFormat(String email){
        return email.contains("@") &&
               email.contains(".");
    }
}
