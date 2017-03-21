package example.androidstudio.swordmagicheart;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


/**
 * Created by thomasmilgrew on 3/20/17.
 */

public class BattleActivity extends AppCompatActivity {

    ImageView playerChoice;
    ImageView computerChoice;
    Integer playerNumericScore = 0;
    Integer computerNumericScore = 0;
    Boolean battleEnable = false; //we use this bool value to keep track of if user picked an option or not
    Integer secondsLeft = 30;
    TextView timer;
    TextView winnerText;
    Button battleButton;
    //TextView playerScore = (TextView)findViewById(R.id.player_score);


    public MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battle_screen);

        //----------------------------------------------------------
        //start the background song for the battle
        //----------------------------------------------------------
        startMediaPlayer(R.raw.battle_loop, true);

        //----------------------------------------------------------
        //finds the button with the rock image and establishes an
        //on click listener
        //----------------------------------------------------------
        ImageButton rockButton = (ImageButton) findViewById(R.id.rock);
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //----------------------------------------------------------
                //find's the player's selected choice and sets the rock
                //image in the main battle area
                //----------------------------------------------------------
                playerChoice = (ImageView) findViewById(R.id.player_battle_choice);
                playerChoice.setImageResource(R.drawable.sword);
                playerChoice.setTag(R.drawable.sword);
                playerChoice.setScaleX(-1);//to make the fist face the correct way
                battleEnable = true;  //allows us to battle
            }
        });

        //----------------------------------------------------------
        //finds the button with the paper image and establishes
        // an on click listener
        //----------------------------------------------------------
        ImageButton paperButton = (ImageButton) findViewById(R.id.paper);
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //----------------------------------------------------------
                //find's the player's selected choice and sets the paper
                //image in the main battle area
                //----------------------------------------------------------
                playerChoice = (ImageView) findViewById(R.id.player_battle_choice);
                playerChoice.setImageResource(R.drawable.magic);
                playerChoice.setTag(R.drawable.magic);
                playerChoice.setScaleX(1); //to fix the scale from rock image
                battleEnable = true; //allows us to battle
            }
        });

        //----------------------------------------------------------
        //finds the button with the scissor image and establishes an
        //on click listener
        //----------------------------------------------------------
        ImageButton scissorButton = (ImageButton) findViewById(R.id.scissor);
        scissorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //----------------------------------------------------------
                //find's the player's selected choice and sets the scissor
                //image in the main battle area
                //----------------------------------------------------------
                playerChoice = (ImageView) findViewById(R.id.player_battle_choice);
                playerChoice.setImageResource(R.drawable.heart);
                playerChoice.setTag(R.drawable.heart);
                playerChoice.setScaleX(1); //to fix the scale from rock image
                battleEnable = true; //allows us to battle
            }
        });

        //----------------------------------------------------------
        //finds the "battle" button and begins the battle
        //----------------------------------------------------------
        battleButton = (Button) findViewById(R.id.battle_button);
        battleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (battleEnable == false) { //if the user did not select a value, show message
                    Toast.makeText(BattleActivity.this, "Select an Option", Toast.LENGTH_SHORT).show();
                } else {
                    setComputerChoice();
                    battle();
                }
            }
        });

        //----------------------------------------------------------
        //starting the timer for the battle
        //----------------------------------------------------------
        timer = (TextView) findViewById(R.id.timer);
        winnerText = (TextView) findViewById(R.id.winner_text);

        new CountDownTimer(32000, 1000) {
            @Override
            public void onTick(long l) {
                timer.setText(secondsLeft.toString());
                secondsLeft = secondsLeft - 1;
            }

            @Override
            public void onFinish() {
                releaseMediaPlayer();

                battleButton.setEnabled(false);
                if (playerNumericScore > computerNumericScore) {
                    startMediaPlayer(R.raw.match_winner, false);
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                    winnerText.setText("You Won!!!");
                }
                if (playerNumericScore < computerNumericScore) {
                    startMediaPlayer(R.raw.match_loser, false);
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                    winnerText.setText("You Lose!!!");
                }
                if (playerNumericScore == computerNumericScore) {
                    startMediaPlayer(R.raw.match_loser, false);
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                    winnerText.setText("Draw!!!");
                }
            }
        }.start();
    }


    //----------------------------------------------------------
    //finds the computer's choice randomly
    //sets the random image and assigns a tag
    //----------------------------------------------------------
    public void setComputerChoice() {
        computerChoice = (ImageView) findViewById(R.id.computer_battle_choice);
        int[] imageOptions = new int[]{R.drawable.sword, R.drawable.magic, R.drawable.heart};
        Random rand = new Random();
        int n = rand.nextInt(3);
        computerChoice.setImageResource(imageOptions[n]);
        computerChoice.setTag(imageOptions[n]);
    }

    public void battle() {

        winnerText = (TextView) findViewById(R.id.winner_text);
        TextView playerScore = (TextView) findViewById(R.id.player_score);
        TextView computerScore = (TextView) findViewById(R.id.computer_score);

        //----------------------------------------------------------
        //if player and computer picked the same thing
        //----------------------------------------------------------
        if (playerChoice.getDrawable().getConstantState().equals(computerChoice.getDrawable().getConstantState())) {
            winnerText.setText("Tie!!!");
        }

        //----------------------------------------------------------
        //if player wins print "You win" otherwise the computer wins
        //----------------------------------------------------------
        else if ((playerChoice.getTag().equals(R.drawable.magic) && computerChoice.getTag().equals(R.drawable.sword))
                || (playerChoice.getTag().equals(R.drawable.sword) && computerChoice.getTag().equals(R.drawable.heart))
                || (playerChoice.getTag().equals(R.drawable.heart) && computerChoice.getTag().equals(R.drawable.magic))) {

            playerNumericScore = playerNumericScore + 1;
            playerScore.setText(playerNumericScore.toString());
            winnerText.setText("Winner!!!");

        } else {
            computerNumericScore = computerNumericScore + 1;
            computerScore.setText(computerNumericScore.toString());
            winnerText.setText("Loser!!!");
        }
    }

    //----------------------------------------------------------
    //when we stop the activity
    //----------------------------------------------------------
    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            //mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    private void startMediaPlayer(int audioResourceID, Boolean loop){
        if(loop == true) {
            mediaPlayer = MediaPlayer.create(this, audioResourceID);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }else{
            mediaPlayer = MediaPlayer.create(this, audioResourceID);
            mediaPlayer.start();
        }
    }
}
