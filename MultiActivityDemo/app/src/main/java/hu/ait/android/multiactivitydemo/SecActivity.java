package hu.ait.android.multiactivitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        TextView tvName = (TextView) findViewById(R.id.tvName);
        if(getIntent().getExtras() != null &&
                getIntent().getExtras().containsKey(MainActivity.KEY_USERNAME))
        {
            tvName.setText(getIntent().getExtras().getString(MainActivity.KEY_USERNAME));
        }
    }
}
