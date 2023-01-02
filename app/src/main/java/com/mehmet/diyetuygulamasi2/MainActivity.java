package com.mehmet.diyetuygulamasi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mehmet.diyetuygulamasi2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    EditText editboy, editkilo , edityas;
    Button hesaplabtn , girisbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        editboy = binding.editTextBoy;
        editkilo = binding.editTextKilo;
        edityas = binding.editTextYas;
        hesaplabtn = binding.buttonhesapla;
        girisbutton = binding.girisbtn;

        hesaplabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double boy , kilo ;
                boy =Integer.parseInt(editboy.getText().toString());
                kilo = Integer.parseInt(editkilo.getText().toString());
                int hesaplama = (int) (kilo / (boy/100 * boy/100));
                Toast.makeText(MainActivity.this, String.valueOf(hesaplama), Toast.LENGTH_SHORT).show();

                if (hesaplama < 18.49){
                    Toast.makeText(MainActivity.this, "İdeal Kilonun Altı", Toast.LENGTH_SHORT).show();
                }else if (hesaplama <18.5 || hesaplama <24.99){
                    Toast.makeText(MainActivity.this, "İdeal Kilo", Toast.LENGTH_SHORT).show();
                }else if (hesaplama < 25 || hesaplama <29.99){
                    Toast.makeText(MainActivity.this, "İdeal Kilonun Üzeri", Toast.LENGTH_SHORT).show();
                }else if (hesaplama <30){
                    Toast.makeText(MainActivity.this, "İdeal Kilonun Çok Üzeri", Toast.LENGTH_SHORT).show();
                }
            }
        });

        girisbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(MainActivity.this,accountLoginSignup.class);
                startActivity(intent);
            }
        });
    }
}