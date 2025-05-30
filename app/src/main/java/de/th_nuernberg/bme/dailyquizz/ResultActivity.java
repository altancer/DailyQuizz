package de.th_nuernberg.bme.dailyquizz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultText = findViewById(R.id.resultText);
        Button homeBtn = findViewById(R.id.homeBtn);

        int score = getIntent().getIntExtra("score", 0);
        int total = getIntent().getIntExtra("total", 0);

        // Punkte addieren und speichern
        SharedPreferences prefs = getSharedPreferences("user", MODE_PRIVATE);
        int previousScore = prefs.getInt("score", 0);
        prefs.edit().putInt("score", previousScore + score).apply();

        resultText.setText("Du hast " + score + " von " + total + " richtig beantwortet!");

        homeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
