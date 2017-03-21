package example.androidstudio.swordmagicheart;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static example.androidstudio.swordmagicheart.R.drawable.rock;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //----------------------------------------------------------
        //set screen to open on the battle screen
        //----------------------------------------------------------
        setContentView(R.layout.activity_main);

        //finds the button that will take us to the battle screen
        Button startButton = (Button)findViewById(R.id.start_button);

        //set a click listener on this button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create new intent to start battle
                Intent battleIntent = new Intent(MainActivity.this, BattleActivity.class);

                //Start the new activity
                startActivity(battleIntent);
            }
        });

    }
}
