package auth;

public class UserAuthenticator {
    //checks whether a token is a token of a member or admin
    //we can have below methods as static methods as we use it frequently
    //to prevent object creation we create private constructor
    private UserAuthenticator(){}
    public static boolean isAdmin(String token){
        return true;
    }
    public static boolean isMember(String token){
        return true;
    }
}
