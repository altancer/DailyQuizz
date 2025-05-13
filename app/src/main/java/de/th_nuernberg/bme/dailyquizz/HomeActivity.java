package de.th_nuernberg.bme.dailyquizz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button geoBtn = findViewById(R.id.geoBtn);
        Button historyBtn = findViewById(R.id.historyBtn);
        Button animalBtn = findViewById(R.id.animalBtn);

        geoBtn.setOnClickListener(v -> startCategory("Geografie"));
        historyBtn.setOnClickListener(v -> startCategory("Geschichte"));
        animalBtn.setOnClickListener(v -> startCategory("Tiere"));
    }

    private void startCategory(String category) {
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("category", category); // z.B. später verwendbar für Anzeige
        startActivity(intent);
    }
}
