package jsp.entities;

import android.app.Application;
import android.content.Context;

import jsp.dbLayout.local.UserInfoModel;

/**
 * Created by Hao on 4/14/16.
 */
public class User {
    private String username;
    private String password;
    private int age;
    private String photo;
    private int status;
    private String lastLocation;
    protected Context ctx;

    public User(Context ctx, String username, String password) {
        this.ctx = ctx;
        this.username = username;
        this.password = password;

        updateLocalUserDB(username, password);
        //TODO: updagteServerUserDb();
    }

    private void updagteServerUserDb(String username, String password, int status, String location) {
        //TODO:
    }

    private void updateLocalUserDB(String username, String password) {
        //TODO:
        UserInfoModel uim = new UserInfoModel(ctx);
        uim.addUser(username, password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(String lastLocation) {
        this.lastLocation = lastLocation;
    }
}
