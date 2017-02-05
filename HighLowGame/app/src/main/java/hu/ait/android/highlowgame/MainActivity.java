package hu.ait.android.highlowgame;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        layoutContent = (LinearLayout) findViewById(R.id.layoutContent);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = (Button) findViewById(R.id.startbtn);
        Button btnHelp = (Button) findViewById(R.id.helpbtn);
        Button btnAbout = (Button) findViewById(R.id.aboutbtn);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNewGame = new Intent();
                intentNewGame.setClass(MainActivity.this, HighLowActivity.class);
                startActivity(intentNewGame);

            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.aboutmsg,
                        Toast.LENGTH_LONG).show();
               // showSnackBarMessage("This game was made by Jake Vitale");
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.helpmsg,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public void showSnackBarMessage(String msg) {
        Snackbar.make(layoutContent, msg,
                Snackbar.LENGTH_LONG).show();
    }

}