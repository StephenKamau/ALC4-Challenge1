package com.example.alc4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnLoadAboutALC;
    private Button btnLoadProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.toolbar_title_a);

        btnLoadAboutALC = findViewById(R.id.btn_about_alc);
        btnLoadAboutALC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadAboutALC();
            }
        });
    }

    private void loadAboutALC() {
        Intent aboutALCIntent = new Intent(this,AboutALCActivity.class);
        startActivity(aboutALCIntent);
    }
}
