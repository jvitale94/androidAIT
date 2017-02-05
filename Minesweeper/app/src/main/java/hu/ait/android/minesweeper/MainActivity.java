package hu.ait.android.minesweeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnstart = (Button) findViewById(R.id.startbtn);
        Button btnhelp = (Button) findViewById(R.id.helpbtn);
        Button btnabout = (Button) findViewById(R.id.aboutbtn);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startgame = new Intent();
                startgame.setClass(MainActivity.this, MinesweeperGame.class);
                startActivity(startgame);
            }
        });

        btnhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.helpmsg,
                        Toast.LENGTH_LONG).show();

            }
        });

        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.aboutmsg,
                        Toast.LENGTH_LONG).show();

            }
        });
    }
}
