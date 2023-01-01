package com.mehmet.diyetuygulamasi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class accountLoginSignup extends AppCompatActivity {

    String email = "mehmet@gmail.com";
    String password = "123";
    // Sistemde kayıtlı 5 farklı e-posta ve şifre
    String[] emails = {"mehmet@gmail.com", "mehmet2@gmail.com", "deneme@gmail.com", "Emin@gmail.com", "user@user"};
    String[] passwords = {"sifre", "mehmet2", "deneme", "emin123", "password"};

    Button girisbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_login_signup);

        girisbtn = findViewById(R.id.button);

        girisbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean loginSuccess = false;

                // Girilen e-posta ve şifre ile sistemde kayıtlı olanlar karşılaştırılıyor
                for (int i = 0; i < emails.length; i++) {
                    if (email.equals(emails[i]) && password.equals(passwords[i])) {
                        loginSuccess = true;
                        break;
                    }
                }

                if (loginSuccess) {
                    // Doğru e-posta ve şifre girildi, başka bir aktiviteye geçiş yapılabilir
                    Intent intent = new Intent(accountLoginSignup.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // Yanlış e-posta veya şifre girildi, Toast mesajı göster
                    Toast.makeText(accountLoginSignup.this, "Yanlış e-posta veya şifre", Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
}
