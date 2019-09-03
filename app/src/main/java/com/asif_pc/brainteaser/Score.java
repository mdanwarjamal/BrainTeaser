package com.asif_pc.brainteaser;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends Activity {
    TextView myScore;
    String str="";
    Button home_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        myScore=findViewById(R.id.textView_my_score);
        home_score=findViewById(R.id.button_home_score);
        str=getIntent().getStringExtra("highscore");
        myScore.append(""+str);
        home_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Score.this,HomePage.class));
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        startActivity(new Intent(Score.this,HomePage.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Score.this,HomePage.class));
    }
}
