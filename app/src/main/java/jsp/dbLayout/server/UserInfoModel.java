package jsp.dbLayout.server;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by Hao on 4/14/16.
 */
public class UserInfoModel {
    // database name
    private static final String DATABASE_NAME = "TEST_USERINFO";
    private SQLiteDatabase database; // database object
    private jsp.dbLayout.local.UserInfoDBHelper userInfoDBHelper; // database helper
    Context context;

    public UserInfoModel(Context context){
        // create a new DatabaseOpenHelper
        this.context = context;
        userInfoDBHelper =
                new jsp.dbLayout.local.UserInfoDBHelper(context, DATABASE_NAME, null, 1);
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
}
