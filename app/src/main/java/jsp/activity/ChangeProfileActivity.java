package jsp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import jsp.dbLayout.local.UserInfoModel;
import jsp.ws.local.UserInfoDBController;


public class ChangeProfileActivity extends Activity implements View.OnClickListener{
    private TextView mTitleView;
    private EditText mUpdateView;
    private Button  button_cancel;
    private Button  button_save;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_changeprofileactivity);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);

        mTitleView = (TextView)findViewById(R.id.titleView);
        mUpdateView = (EditText) findViewById(R.id.updateView);
        button_save = (Button) findViewById(R.id.button_save);
        button_cancel = (Button) findViewById(R.id.button_cancel);
        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");

        mTitleView.setText(bundle.getString("title"));
        button_cancel.setOnClickListener(this);
        button_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_save){
            String newUsername = mUpdateView.getText().toString();
            View focusView = null;
            boolean cancel = false;

            UserInfoModel uim = new UserInfoModel(this);
            UserInfoDBController controller = new UserInfoDBController(this);
            // Check for a valid username address.
            if (TextUtils.isEmpty(newUsername)) {
                mUpdateView.setError(getString(R.string.error_field_required));
                cancel = true;
                focusView = mUpdateView;
            } else if (!controller.isUsernameValid(newUsername)) {
                mUpdateView.setError(getString(R.string.error_invalid_username));
                cancel = true;
                focusView = mUpdateView;
            }

            if (cancel) {
                // There was an error; don't attempt login and focus the first
                // form field with an error.
                focusView.requestFocus();
            } else {
                // Show a progress spinner, and kick off a background task to
                // perform the user login attempt.
//                uim.updateUsername(username, newUsername);
                UserInfoDBController uidbc = new UserInfoDBController(this);
                uidbc.getUser().updateUsername(newUsername);
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
            }

        }else{
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
    }
}
