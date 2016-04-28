package jsp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FriendsActivity extends Activity{
    public static String[] friendsArray = {"Hao(0.5 mile)", "Jason Wang(1 mile)", "Bob(1.5 mile)", "Daniel(2 miles)", "Lala(2.5 miles)", "Mike(3miles)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_friendsactivity);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);

        ArrayAdapter adaptor = new ArrayAdapter<String>(this, R.layout.profile_listview, friendsArray);
        ListView listView = (ListView) findViewById(R.id.friendsListView);
        listView.setAdapter(adaptor);
    }
}
