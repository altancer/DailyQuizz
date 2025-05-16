package de.th_nuernberg.bme.dailyquizz;

import android.content.Intent;
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

        // Prüfe, ob Antwort korrekt war
        boolean isCorrect = getIntent().getBooleanExtra("result", false);

        if (isCorrect) {
            resultText.setText("Richtig! Gute Arbeit 👏");
        } else {
            resultText.setText("Falsch 😢 Die richtige Antwort war: Paris");
        }

        homeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });
    }
}
