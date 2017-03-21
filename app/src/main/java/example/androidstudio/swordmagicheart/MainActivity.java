package example.androidstudio.swordmagicheart;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    public MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //----------------------------------------------------------
        //start the background song for the battle
        //----------------------------------------------------------
        mediaPlayer = MediaPlayer.create(this, R.raw.opening_theme);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        //----------------------------------------------------------
        //set screen to open on the battle screen
        //----------------------------------------------------------
        setContentView(R.layout.activity_main);

        //finds the button that will take us to the battle screen
        Button startButton = (Button)findViewById(R.id.start_button);

        //set a click listener on this button
        startButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //create new intent to start battle
                Intent battleIntent = new Intent(MainActivity.this, BattleActivity.class);

                //Start the new activity
                startActivity(battleIntent);
            }
        });

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

    //----------------------------------------------------------
    //when we start the activity again
    //----------------------------------------------------------
    @Override
    protected void onStart() {
        super.onStart();
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, R.raw.opening_theme);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
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
}
