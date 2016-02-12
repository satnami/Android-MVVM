package satnami.com.mvvm.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import satnami.com.mvvm.R;
import satnami.com.mvvm.view.fragment.GistsFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addGistsFragment();
    }

    private void addGistsFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, new GistsFragment())
                .commit();
    }
}
