package jsp.dbLayout.server;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Hao on 4/14/16.
 */
public class UserInfoDBHelper extends SQLiteOpenHelper {
    // public constructor
    public UserInfoDBHelper (Context context, String name,
                             SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    } // end DatabaseOpenHelper constructor

    // creates the contacts table when the database is created
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // query to create a new table named contacts

        String query = "CREATE TABLE IF NOT EXISTS userInfo" +
                "(userInfo_ID INTEGER PRIMARY KEY AUTO INCREMENT , " +
                "username STRING NOT NULL, " +
                "password STRING NOT NULL, " +
                "photo STRING, " +
                "age INTEGER);";

        db.execSQL(query); // execute the query
        Log.d("UserInfoDB", "table-userinfo is created");
    } // end method onCreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion)
    {
    } // end method onUpgrade
}
