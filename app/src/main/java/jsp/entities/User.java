package jsp.entities;

import android.content.Context;

import jsp.dbLayout.local.UserInfoModel;

/**
 * Created by Hao on 4/14/16.
 */
public class User {
    private String username;
    private String password;
    private int userId;
    private int age;
    private String photo;
    private int status;
    private String lastLocation;
    protected Context ctx;

    public User(Context ctx, String username, String password) {
        this.ctx = ctx;
        this.username = username;
        this.password = password;

        this.userId = addToLocalUserDB(username, password);
        //TODO: updagteServerUserDb();
    }

    private void updagteServerUserDb(String username, String password, int status, String location) {
        //TODO:
    }

    private int addToLocalUserDB(String username, String password) {
        //TODO:
        UserInfoModel uim = new UserInfoModel(ctx);
        return uim.addUser(username, password);
    }

    private void updateLocalUserDB(int userId, String username, String password, int age){
        UserInfoModel uim = new UserInfoModel(ctx);
        uim.updateUser(userId, username, password, age);
    }

    public void updateUsername(String newUsername){
        setUsername(newUsername);
        updateLocalUserDB(userId, username, password, age);

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
