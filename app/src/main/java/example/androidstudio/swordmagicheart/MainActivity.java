package example.androidstudio.swordmagicheart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import static example.androidstudio.swordmagicheart.R.drawable.rock;

public class MainActivity extends AppCompatActivity {

    ImageView playerChoice;
    ImageView computerChoice;

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
                //find's the player's selected choice and sets the rock
                //image in the main battle area
                //----------------------------------------------------------
                playerChoice = (ImageView)findViewById(R.id.player_battle_choice);
                playerChoice.setImageResource(R.drawable.rock);
                playerChoice.setTag(R.drawable.rock);
                playerChoice.setScaleX(-1);//to make the fist face the correct way
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
                //find's the player's selected choice and sets the paper
                //image in the main battle area
                //----------------------------------------------------------
                playerChoice = (ImageView)findViewById(R.id.player_battle_choice);
                playerChoice.setImageResource(R.drawable.paper);
                playerChoice.setTag(R.drawable.paper);
                playerChoice.setScaleX(1); //to fix the scale from rock image
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
                //find's the player's selected choice and sets the scissor
                //image in the main battle area
                //----------------------------------------------------------
                playerChoice = (ImageView)findViewById(R.id.player_battle_choice);
                playerChoice.setImageResource(R.drawable.scissor);
                playerChoice.setTag(R.drawable.scissor);
                playerChoice.setScaleX(1); //to fix the scale from rock image
            }
        });

        //----------------------------------------------------------
        //finds the "battle" button and begins the battle
        //----------------------------------------------------------
        Button battleButton = (Button)findViewById(R.id.battle_button);
        battleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setComputerChoice();
                battle();
            }
        });
    }

    //----------------------------------------------------------
    //finds the computer's choice randomly
    //sets the random image and assigns a tag
    //----------------------------------------------------------
    public void setComputerChoice(){
        computerChoice = (ImageView)findViewById(R.id.computer_battle_choice);
        int [] imageOptions = new int[] {R.drawable.rock, R.drawable.paper, R.drawable.scissor};
        Random rand = new Random();
        int n = rand.nextInt(3);
        computerChoice.setImageResource(imageOptions[n]);
        computerChoice.setTag(imageOptions[n]);
    }

    public void battle(){

        TextView winnerText = (TextView)findViewById(R.id.winner_text);


        //----------------------------------------------------------
        //if player and computer picked the same thing
        //----------------------------------------------------------
        if(playerChoice.getDrawable().getConstantState().equals(computerChoice.getDrawable().getConstantState())){
            winnerText.setText("It is a Tie!!!");
        }

        //----------------------------------------------------------
        //if player wins print "You win" otherwise the computer wins
        //----------------------------------------------------------
        else if((playerChoice.getTag().equals(R.drawable.paper) && computerChoice.getTag().equals(R.drawable.rock))
            || (playerChoice.getTag().equals(R.drawable.rock) && computerChoice.getTag().equals(R.drawable.scissor))
            || (playerChoice.getTag().equals(R.drawable.scissor) && computerChoice.getTag().equals(R.drawable.paper))){

            winnerText.setText("You win!!!");

        }else{
            winnerText.setText("The Computer Wins!!!");
        }
    }
}
