package com.example.xdiam0nd.happyoclock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button mainSectorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mainSectorButton = (Button)  findViewById(R.id.nextButton);
        mainSectorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainSector();
            }
        });

    }

    public void openMainSector() {
        Intent intentMainSector = new Intent(HomeActivity.this, Main_Sector_Selection.class);
        startActivity(intentMainSector);
        finish();

    }
}
