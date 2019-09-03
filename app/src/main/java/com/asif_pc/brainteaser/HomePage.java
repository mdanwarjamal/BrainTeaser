package com.asif_pc.brainteaser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends Activity {
    Button play,about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        play=findViewById(R.id.button_play);
        about=findViewById(R.id.button_about);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this,RulePage.class));
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this,AboutPage.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent ihome=new Intent(Intent.ACTION_MAIN);
        ihome.addCategory(Intent.CATEGORY_HOME);
        ihome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ihome);
    }
}
