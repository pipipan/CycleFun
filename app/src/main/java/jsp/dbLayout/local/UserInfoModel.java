package jsp.dbLayout.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Hao on 4/14/16.
 */
public class UserInfoModel {
    // database name
    private static final String DATABASE_NAME = "TEST_USERINFO1";
    private SQLiteDatabase database; // database object
    private UserInfoDBHelper userInfoDBHelper; // database helper
    Context context;

    public UserInfoModel(Context context){
        // create a new DatabaseOpenHelper
        this.context = context;
        userInfoDBHelper =
                new UserInfoDBHelper(context, DATABASE_NAME, null, 1);
    }

    // open the database connection
    public void open() throws SQLException
    {
        // create or open a database for reading/writing
        database = userInfoDBHelper.getWritableDatabase();
    } // end method open

    // close the database connection
    public void close()
    {
        if (database != null)
            database.close(); // close the database connection
    } // end method close

    //get user info and show on profile activity
    public ArrayList getUserInfo(int userId){
        ArrayList userInfo = new ArrayList<String>();
        String sql = "SELECT username, password, age FROM userInfo WHERE userInfo_ID == " + userId + ";";
        try {
            open();
            Cursor c = database.rawQuery(sql, null);
            while(c.moveToNext()){
                for(int i = 0; i < c.getColumnCount(); i++){
                    if(c.isNull(i)){
                        userInfo.add("n.a");
                    }else if(i == 1){
                        int len = c.getString(i).length();
                        StringBuilder sb = new StringBuilder();
                        for(int j = 0; j < len; j++){
                            sb.append('*');
                        }
                        userInfo.add(sb.toString());
                    }else{
                        userInfo.add(c.getString(i));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return userInfo;
    }

    // inserts a new user into local database
    public int addUser(String username, String password)
    {
        ContentValues newUser = new ContentValues();
        int userId = -1;
        newUser.put("username", username);
        newUser.put("password", password);

        try{
            open(); // open the database
            userId = (int) database.insertWithOnConflict("userInfo", null, newUser, SQLiteDatabase.CONFLICT_IGNORE);
            close(); // close the database
            Log.d("UserInfoModel", "user info stored in local");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return userId;
    } // end method insertContact

    public void updateUser(int userId, String username, String password, int age){
        ContentValues userInfo = new ContentValues();
        String whereClause = "userInfo_ID == " + userId;
        userInfo.put("username", username);
        userInfo.put("password", password);
        userInfo.put("age", age);

        try{
            open(); // open the database
            database.update("userInfo", userInfo, whereClause, null);
//            String sql = "UPDATE userInfo SET username = '" + newUsername
//                    + "' WHERE username = '" + oldUsername + "';";
//            database.rawQuery(sql, null);
            close(); // close the database
            Log.d("UserInfoModel", "username updated");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    // update username
    public void updateUsername(String oldUsername, String newUsername)
    {

        try{
            open(); // open the database
            String sql = "UPDATE userInfo SET username = '" + newUsername
                    + "' WHERE username = '" + oldUsername + "';";
            database.rawQuery(sql, null);
            close(); // close the database
            Log.d("UserInfoModel", "username updated");
        }catch(SQLException e){
            e.printStackTrace();
        }
    } // end method insertContact


}
