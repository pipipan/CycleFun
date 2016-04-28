package jsp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RoutesActivity extends Activity {
    public static String[] recommendationsArray = {"Santa Clara --> Mountain View", "Palo Alto --> Milpitals", "Cupertino --> San Jose", "San Jose --> San Francisco", "Fremont --> Redwood City"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.recommendation);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);

        ArrayAdapter adaptor = new ArrayAdapter<String>(this, R.layout.profile_listview, recommendationsArray);
        ListView listView = (ListView) findViewById(R.id.recommendationsListView);
        listView.setAdapter(adaptor);
    }
}
