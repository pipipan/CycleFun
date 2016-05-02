package jsp.ws.local;

/**
 * Created by Hao on 4/14/16.
 */
public class UserInfoDBController {

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
        if(userExist(username)){
            //TODO: add the logic to compare with server side DB

        }else{
            return false;
        }
        return true;
    };

    public boolean verifySignup(String username, String password){
        if(!userExist(username)){
            //TODO: add the new user info to both local and server side DBs

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
