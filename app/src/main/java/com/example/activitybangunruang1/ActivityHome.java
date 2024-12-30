package com.example.activitybangunruang1;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityHome extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.btnPersegi).setOnClickListener(view -> ActivityInput("persegi"));
        findViewById(R.id.btnPersegiPanjang).setOnClickListener(view -> ActivityInput("persegi panjang"));
        findViewById(R.id.btnLingkaran).setOnClickListener(view -> ActivityInput("lingkaran"));
        findViewById(R.id.btnSegitiga).setOnClickListener(view -> ActivityInput("segitiga"));
    }

    private void ActivityInput(String bentuk){
        Intent intent = new Intent(this , ActivityInput.class);
        intent.putExtra("bentuk", bentuk);
        startActivity(intent);
    }
}
