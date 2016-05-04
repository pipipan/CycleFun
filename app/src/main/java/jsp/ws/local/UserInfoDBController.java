package jsp.ws.local;

import android.content.Context;

import jsp.entities.User;

/**
 * Created by Hao on 4/14/16.
 */
public class UserInfoDBController {


    private static User user;
    protected Context ctx;

    public UserInfoDBController(Context ctx) {
        this.ctx = ctx;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        UserInfoDBController.user = user;
    }

    public boolean isUsernameValid(String username) {
        return username.length() >= 5;
    }

    public boolean isPasswordValid(String password) {
        return password.matches(".*[a-zA-Z]+.*") && password.matches(".*[0-9].*");
    }

    public boolean isConfirmPasswordMatch(String password, String confirmPassword) {
        return password.matches(confirmPassword);
    }


    public boolean verifyLogin(String username, String password){
//        if(userExist(username)){
//            //TODO: add the logic to compare with server side DB
//
//        user = new User(username, password);
//
//        }else{
//            return false;
//        }
        user = new User(ctx, username, password);
        return true;
    };

    public boolean verifySignup(String username, String password){
        if(!userExist(username)){
            //TODO: add the new user info to both local and server side DBs

            user = new User(ctx, username, password);

        }else{
            return false;
        }
        return true;
    };

    public boolean userExist(String userrname){
        //TODO: check server side DB if the username exists

        return false;
    }
}
