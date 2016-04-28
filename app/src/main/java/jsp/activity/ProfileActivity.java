package jsp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProfileActivity extends Activity {
    public static String[] profileArray = {"Name", "Jason Wang", "Phone", "(415) 111-222", "Gender", "Male"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_profileactivity);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);

        ArrayAdapter adaptor = new ArrayAdapter<String>(this, R.layout.profile_listview, profileArray);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adaptor);
    }
}
