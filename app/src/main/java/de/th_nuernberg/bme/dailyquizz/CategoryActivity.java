package de.th_nuernberg.bme.dailyquizz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Button geoBtn = findViewById(R.id.geoBtn);
        Button politikBtn = findViewById(R.id.politikBtn);
        Button tiereBtn = findViewById(R.id.tiereBtn);
        Button geschichteBtn = findViewById(R.id.geschichteBtn);

        geoBtn.setOnClickListener(v -> openQuiz("Geografie"));
        politikBtn.setOnClickListener(v -> openQuiz("Politik"));
        tiereBtn.setOnClickListener(v -> openQuiz("Tiere"));
        geschichteBtn.setOnClickListener(v -> openQuiz("Geschichte"));
    }

    private void openQuiz(String category) {
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}
