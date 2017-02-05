package hu.ait.android.lifecycledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_LIFE = "TAG_LIFE";
    private long firstBack = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG_LIFE, "onCreate() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG_LIFE, "onStart() called");
    }

    @Override
    public void onBackPressed() {

        if (System.currentTimeMillis() - firstBack > 2000) {
            Toast.makeText(this, "Press again in 2 second", Toast.LENGTH_LONG).show();
            firstBack = System.currentTimeMillis();
        } else super.onBackPressed();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG_LIFE, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG_LIFE, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG_LIFE, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG_LIFE, "onDestroy() called");
    }

}
