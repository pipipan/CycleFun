package jsp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import jsp.dbLayout.local.UserInfoModel;
import jsp.ws.local.UserInfoDBController;

public class ProfileActivity extends Activity {
    public static String[] profileArray = {"Username", "", "Password", "", "Age", ""};
    int userId;
    String username;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_profileactivity);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);

        updateList();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position){
                    case 1:
                        intent = new Intent(ProfileActivity.this, ChangeProfileActivity.class);
                        intent.putExtra("title", "Username");
                        intent.putExtra("username", username);
                        startActivity(intent);
                        break;
                    case 3: renderRevisionPage("ChangePasswordActivity", "Password");
                        break;
                    case 5:
                        intent = new Intent(ProfileActivity.this, ChangeProfileActivity.class);
                        intent.putExtra("title", "Age");
                        intent.putExtra("username", username);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    private void updateList() {
        UserInfoDBController uidbc = new UserInfoDBController(this);
        UserInfoModel uim = new UserInfoModel(this);
        userId  = uidbc.getUser().getUserId();
        ArrayList<String> userInfo = uim.getUserInfo(userId);
        profileArray[1] = userInfo.get(0);
        profileArray[3] = userInfo.get(1);
        profileArray[5] = userInfo.get(2);

        ArrayAdapter adaptor = new ArrayAdapter<String>(this, R.layout.profile_listview, profileArray);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adaptor);
    }

    @Override
    protected void onResume(){
        super.onResume();
        updateList();
    }

    private void renderRevisionPage(String className, String title){
        Intent intent = null;
        try {
            intent = new Intent(ProfileActivity.this, Class.forName(className));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        intent.putExtra("title", title);
        startActivity(intent);
    }
}
