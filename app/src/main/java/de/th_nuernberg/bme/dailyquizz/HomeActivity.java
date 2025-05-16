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

        Button friendsBtn = findViewById(R.id.friendsBtn);
        Button rankingBtn = findViewById(R.id.rankingBtn);
        Button quizBtn = findViewById(R.id.quizBtn);

        // Freunde-Button
        friendsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, FriendsActivity.class);
            startActivity(intent);
        });

        // Ranking-Button
        rankingBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, RankingActivity.class);
            startActivity(intent);
        });

        // Quiz-Button → geht jetzt zur Kategorie-Auswahl
        quizBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, CategoryActivity.class);
            startActivity(intent);
        });
    }
}
