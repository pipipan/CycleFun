package jsp.dbLayout.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Hao on 4/14/16.
 */
public class MessageModel {
    // database name
    private static final String DATABASE_NAME = "TEST_MSG";
    private SQLiteDatabase database; // database object
    private MessageDBHelper messageDBHelper; // database helper
    Context context;

    public MessageModel(Context context){
        // create a new DatabaseOpenHelper
        this.context = context;
        messageDBHelper =
                new MessageDBHelper(context, DATABASE_NAME, null, 1);

    }

    // open the database connection
    public void open() throws SQLException
    {
        // create or open a database for reading/writing
        database = messageDBHelper.getWritableDatabase();
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
//    // inserts a set of new input data in the database
//    public void insertInput()
//    {
//        try {
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(context.getAssets().open("scores.txt"))
//            );
//            Log.d("io", "reading text file");
//
//            String str = reader.readLine();
//
//            while(str != null){
//                String[] input = str.split("\t");
//                ContentValues newInput = new ContentValues();
//                newInput.put("studentID", input[0]);
//                newInput.put("quiz1", input[1]);
//                newInput.put("quiz2", input[2]);
//                newInput.put("quiz3", input[3]);
//                newInput.put("quiz4", input[4]);
//                newInput.put("quiz5", input[5]);
//
//                try{
//                    open(); // open the database
//                    database.insert("scores", null, newInput);
//                    close(); // close the database
//                    Log.d("insert", "score data is stored");
//                }catch(SQLException e){
//                    e.printStackTrace();
//                }
//                str = reader.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    } // end method insertContact


}
