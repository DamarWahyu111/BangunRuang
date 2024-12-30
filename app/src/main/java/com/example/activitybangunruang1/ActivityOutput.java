package com.example.activitybangunruang1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityOutput extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        double luas = getIntent().getDoubleExtra("luas", 0);
        double keliling = getIntent().getDoubleExtra("keliling", 0);

        TextView txtLuas = findViewById(R.id.txtLuas);
        TextView txtKeliling = findViewById(R.id.txtKeliling);

        txtLuas.setText("Luas: " + luas);
        txtKeliling.setText("Keliling: " + keliling);
    }
}
