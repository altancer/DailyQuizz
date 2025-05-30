package de.th_nuernberg.bme.dailyquizz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences prefs = getSharedPreferences("user", MODE_PRIVATE);
        String username = prefs.getString("username", "User");
        int score = prefs.getInt("score", 0);

        TextView usernameDisplay = findViewById(R.id.usernameDisplay);
        TextView scoreDisplay = findViewById(R.id.scoreDisplay);
        Button friendsBtn = findViewById(R.id.friendsBtn);
        Button rankingBtn = findViewById(R.id.rankingBtn);
        Button quizBtn = findViewById(R.id.quizBtn);

        usernameDisplay.setText("Willkommen, " + username + "!");
        scoreDisplay.setText("Punkte: " + score);

        friendsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, FriendsActivity.class);
            startActivity(intent);
        });

        rankingBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, RankingActivity.class);
            startActivity(intent);
        });

        quizBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, CategoryActivity.class);
            startActivity(intent);
        });
    }
}
