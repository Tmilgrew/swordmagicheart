package example.androidstudio.swordmagicheart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import static example.androidstudio.swordmagicheart.R.drawable.rock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set screen to open on the battle screen
        setContentView(R.layout.battle_screen);

        //----------------------------------------------------------
        //finds the button with the rock image and establishes an
        //on click listener
        //----------------------------------------------------------
        final ImageButton rockButton = (ImageButton)findViewById(R.id.rock);
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //----------------------------------------------------------
                //add code to make main battle image the rock image
                //----------------------------------------------------------
                ImageView playerChoice = (ImageView)findViewById(R.id.player_battle_choice);
                playerChoice.setImageResource(R.drawable.rock);
                playerChoice.setScaleX(-1);

            }
        });

        //----------------------------------------------------------
        //finds the button with the paper image and establishes
        // an on click listener
        //----------------------------------------------------------
        final ImageButton paperButton = (ImageButton)findViewById(R.id.paper);
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //----------------------------------------------------------
                //add code to make main battle image the paper image
                //----------------------------------------------------------
                ImageView playerChoice = (ImageView)findViewById(R.id.player_battle_choice);
                playerChoice.setImageResource(R.drawable.paper);
                playerChoice.setScaleX(1);
            }
        });

        //----------------------------------------------------------
        //finds the button with the scissor image and establishes an
        //on click listener
        //----------------------------------------------------------
        final ImageButton scissorButton = (ImageButton)findViewById(R.id.scissor);
        scissorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //----------------------------------------------------------
                //add code to make main battle image the scissor image
                //----------------------------------------------------------
                ImageView playerChoice = (ImageView)findViewById(R.id.player_battle_choice);
                playerChoice.setImageResource(R.drawable.scissor);
                playerChoice.setScaleX(1);
            }
        });
    }
}
