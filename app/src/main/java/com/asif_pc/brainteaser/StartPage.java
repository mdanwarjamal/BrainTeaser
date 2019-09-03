package com.asif_pc.brainteaser;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class StartPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        TextView view=findViewById(R.id.textView);
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(StartPage.this,HomePage.class));
            }
        },3000);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        startActivity(new Intent(StartPage.this,HomePage.class));
    }
}
