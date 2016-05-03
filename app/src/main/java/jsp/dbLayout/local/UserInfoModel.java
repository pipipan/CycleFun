package jsp.dbLayout.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;
import java.sql.SQLException;

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

//    public ArrayList getStudentList(){
//        ArrayList students = new ArrayList<String>();
//        String sql = "SELECT studentID FROM scores";
//        try {
//            open();
//            Cursor c = database.rawQuery(sql, null);
//            while(c.moveToNext()){
//                students.add(c.getString(0));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        close();
//        return students;
//    }
//
    // inserts a new user into local database
    public void addUser(String username, String password)
    {
        ContentValues newUser = new ContentValues();
        newUser.put("username", username);
        newUser.put("password", password);

        try{
            open(); // open the database
            database.insertWithOnConflict("userInfo", null, newUser, SQLiteDatabase.CONFLICT_IGNORE);
            close(); // close the database
            Log.d("UserInfoModel", "user info stored in local");
        }catch(SQLException e){
            e.printStackTrace();
        }
    } // end method insertContact


}
