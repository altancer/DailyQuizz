package de.th_nuernberg.bme.dailyquizz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Google-Login-Dummy
        Button googleBtn = findViewById(R.id.googleLoginBtn);
        googleBtn.setOnClickListener(v -> {
            // Hier später echte Auth einbauen
            startActivity(new Intent(this, HomeActivity.class));
        });

        // Facebook-Login-Dummy
        Button facebookBtn = findViewById(R.id.facebookLoginBtn);
        facebookBtn.setOnClickListener(v -> {
            // Hier später echte Auth einbauen
            startActivity(new Intent(this, HomeActivity.class));
        });
    }
}
