package example.androidstudio.swordmagicheart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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
        ImageButton rockButton = (ImageButton)findViewById(R.id.rock);
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //----------------------------------------------------------
                //add code to make main battle image the rock image
                //----------------------------------------------------------
            }
        });

        //----------------------------------------------------------
        //finds the button with the paper image and establishes
        // an on click listener
        //----------------------------------------------------------
        ImageButton paperButton = (ImageButton)findViewById(R.id.paper);
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //----------------------------------------------------------
                //add code to make main battle image the paper image
                //----------------------------------------------------------
            }
        });

        //----------------------------------------------------------
        //finds the button with the scissor image and establishes an
        //on click listener
        //----------------------------------------------------------
        ImageButton scissorButton = (ImageButton)findViewById(R.id.scissor);
        scissorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //----------------------------------------------------------
                //add code to make main battle image the scissor image
                //----------------------------------------------------------
            }
        });
    }
}
