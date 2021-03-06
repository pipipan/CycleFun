package jsp.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import jsp.dbLayout.local.UserInfoModel;
import jsp.ws.local.UserInfoDBController;

public class ProfileActivity extends Activity {
    private static final int PICK_PHOTO_FOR_AVATAR = 0;
    public static String[] profileArray = {"Username", "", "Password", "", "Age", ""};
    int userId;
    String username;
    ListView listView;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_profileactivity);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);

        listView = (ListView) findViewById(R.id.listView);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        updateList();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImage();
            }
        });

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

    private void pickImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_PHOTO_FOR_AVATAR);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_PHOTO_FOR_AVATAR && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                //Display an error
                return;
            }

            try {
                InputStream inputStream = this.getContentResolver().openInputStream(data.getData());
                imageButton.setImageBitmap(BitmapFactory.decodeStream(inputStream));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //Now you can do whatever you want with your inpustream, save it as file, upload to a server, decode a bitmap...
        }
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
