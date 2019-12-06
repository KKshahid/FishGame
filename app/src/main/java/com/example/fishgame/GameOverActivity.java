package com.example.fishgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {
    private Button StartGameAgain;
    private TextView Display;
    private String scorer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_over);

        StartGameAgain=(Button) findViewById(R.id.BTN_again);
        Display=(TextView)findViewById(R.id.textViewScore);

        scorer= getIntent().getExtras().get("Score").toString();

        StartGameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mainIntent=new Intent(GameOverActivity .this,MainActivity.class);
                startActivity(mainIntent);
            }
        });
        Display.setText("Score ="+scorer);
    }
}
