package jsp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class LoginActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_loginactivity);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);
        // Set up the activity_loginactivity form.
    }

    public void renderSignup(View view){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
//        Intent intentMap = new Intent(this, MapsActivity.class);
//        startActivityForResult(intentMap, 1);
    }

    public void renderMainmap(View view) {
        Intent intentMap = new Intent(this, HomeActivity.class);
        startActivity(intentMap);
    }
}

