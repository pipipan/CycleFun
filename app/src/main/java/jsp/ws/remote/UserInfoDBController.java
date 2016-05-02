package jsp.ws.remote;

/**
 * Created by Hao on 4/14/16.
 */
public class UserInfoDBController {
    public boolean isUsernameValid(String username) {
        //TODO: Replace this with your own logic
        return username.length() >= 5;
    }

    public boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.matches(".*[a-zA-Z]+.*") && password.matches(".*[0-9].*");
    }



    public boolean verifyLogin(String username, String password){
        return true;
    };

    public boolean verifySignup(String username, String password){
        return false;
    };

    public boolean userExist(){
        return false;
    }
}
