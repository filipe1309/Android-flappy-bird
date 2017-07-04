package br.com.alura.jumper;

import android.app.Activity;
import android.os.Bundle;

import br.com.alura.jumper.engine.Game;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Game game = new Game(this);
    }
}
