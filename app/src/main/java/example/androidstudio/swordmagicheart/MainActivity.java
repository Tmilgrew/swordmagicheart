package example.androidstudio.swordmagicheart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set screen to open on the battle screen
        setContentView(R.layout.battle_screen);
    }
}
