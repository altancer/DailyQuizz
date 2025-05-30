package de.th_nuernberg.bme.dailyquizz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText usernameInput = findViewById(R.id.usernameInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        Button loginBtn = findViewById(R.id.loginBtn);
        Button googleBtn = findViewById(R.id.googleLoginBtn);
        Button facebookBtn = findViewById(R.id.facebookLoginBtn);

        loginBtn.setOnClickListener(v -> {
            String username = usernameInput.getText().toString();

            SharedPreferences prefs = getSharedPreferences("user", MODE_PRIVATE);
            prefs.edit().putString("username", username).apply();

            startActivity(new Intent(this, HomeActivity.class));
        });

        googleBtn.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("user", MODE_PRIVATE);
            prefs.edit().putString("username", "GoogleUser").apply();

            startActivity(new Intent(this, HomeActivity.class));
        });

        facebookBtn.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("user", MODE_PRIVATE);
            prefs.edit().putString("username", "FacebookUser").apply();

            startActivity(new Intent(this, HomeActivity.class));
        });
    }
}