package de.th_nuernberg.bme.dailyquizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button startQuestionBtn = findViewById(R.id.startQuestionBtn);
        startQuestionBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, QuestionActivity.class);
            startActivity(intent);
        });
    }
}
