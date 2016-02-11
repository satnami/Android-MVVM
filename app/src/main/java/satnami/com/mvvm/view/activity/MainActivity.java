package satnami.com.mvvm.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import satnami.com.mvvm.R;
import satnami.com.mvvm.view.fragment.GistsFragment;

public class MainActivity extends AppCompatActivity {

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

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
