package com.mehmet.diyetuygulamasi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class accountLoginSignup extends AppCompatActivity {


    EditText email,password;
    Button girisbtn;
    // Sistemde kayıtlı 5 farklı e-posta ve şifre
    String[] emails = {"mehmet@gmail.com", "mehmet2@gmail.com", "deneme@gmail.com", "Emin@gmail.com", "user@user"};
    String[] passwords = {"sifre", "mehmet2", "deneme", "emin123", "password"};
    boolean loginSuccess = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_login_signup);

        girisbtn = findViewById(R.id.button);
        email = findViewById(R.id.enterEmail);
        password = findViewById(R.id.enterPasswords);

        girisbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Girilen e-posta ve şifre ile sistemde kayıtlı olanlar karşılaştırılıyor
                for (int i = 0; i < emails.length; i++) {
                    if (email.getText().toString().equals(emails[i]) && password.getText().toString().equals(passwords[i])) {
                        loginSuccess = true;
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
