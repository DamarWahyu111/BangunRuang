package com.example.activitybangunruang1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityInput extends AppCompatActivity {
    private EditText angka1, angka2;
    private String bentuk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        bentuk = getIntent().getStringExtra("bentuk");
        angka1 = findViewById(R.id.angka1);
        angka2 = findViewById(R.id.angka2);

        inputBentuk();
        findViewById(R.id.btnResult).setOnClickListener(view -> kalkulasiBangunDatar());
    }

    private void inputBentuk(){
        switch (bentuk){
            case "persegi":
                angka1.setHint("sisi");
                angka2.setVisibility(View.GONE);
                break;
            case "persegi panjang":
                angka1.setHint("Panjang");
                angka2.setHint("Lebar");
                angka2.setVisibility(View.VISIBLE);
                break;
            case "lingkaran":
                angka1.setHint("Radius");
                angka2.setVisibility(View.GONE);
                break;
            case "segitiga" :
                angka1.setHint("Alas");
                angka2.setHint("Tinggi");
                angka2.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void kalkulasiBangunDatar() {
        double hasilLuas = 0, hasilKeliling = 0;

        try {
            double kal1 = Double.parseDouble(angka1.getText().toString());
            double kal2 = angka2.getVisibility() == View.VISIBLE ? Double.parseDouble(angka2.getText().toString()) : 0;

            switch (bentuk) {
                case "persegi":
                    hasilLuas = kal1 * kal1;
                    hasilKeliling = 4 * kal1;
                    break;
                case "persegi panjang":
                    hasilLuas = kal1 * kal2;
                    hasilKeliling = 2 * (kal1 + kal2);
                    break;
                case "lingkaran":
                    hasilLuas = Math.PI * kal1 * kal1;
                    hasilKeliling = 2 * Math.PI * kal1;
                    break;
                case "segitiga":
                    hasilLuas = 0.5 * kal1 * kal2;
                    hasilKeliling = kal1 + kal2 + Math.sqrt(kal1 * kal1 + kal2 * kal2);
                    break;
            }
            Intent intent = new Intent(this, ActivityOutput.class);
            intent.putExtra("luas", hasilLuas);
            intent.putExtra("keliling", hasilKeliling);
            startActivity(intent);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid number", Toast.LENGTH_SHORT).show();

        }
    }
}