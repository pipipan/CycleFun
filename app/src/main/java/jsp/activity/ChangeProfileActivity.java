package jsp.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;


public class ChangeProfileActivity extends Activity {
    private TextView mTitleView;
    private EditText mUpdateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_changeprofileactivity);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);

        mTitleView = (TextView)findViewById(R.id.titleView);
        mUpdateView = (EditText) findViewById(R.id.updateView);

        mTitleView.setText(getIntent().getExtras().getString("title"));

    }

}
