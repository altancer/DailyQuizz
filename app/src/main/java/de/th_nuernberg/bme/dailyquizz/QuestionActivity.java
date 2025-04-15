package de.th_nuernberg.bme.dailyquizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Button answerBtn = findViewById(R.id.answerBtn);
        answerBtn.setOnClickListener(v -> {
            Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
            startActivity(intent);
        });
    }
}
