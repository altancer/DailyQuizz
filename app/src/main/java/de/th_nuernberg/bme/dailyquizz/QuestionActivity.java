package de.th_nuernberg.bme.dailyquizz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {

    private String selectedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // Kategorie aus vorherigem View empfangen
        selectedCategory = getIntent().getStringExtra("category");

        TextView categoryText = findViewById(R.id.categoryText);
        categoryText.setText("Kategorie: " + selectedCategory);

        // Dummy-Frage anzeigen
        TextView questionText = findViewById(R.id.questionText);
        questionText.setText("Was ist die Hauptstadt von Frankreich?");

        Button answerA = findViewById(R.id.answerA);
        Button answerB = findViewById(R.id.answerB);
        Button answerC = findViewById(R.id.answerC);
        Button answerD = findViewById(R.id.answerD);

        // Alle Buttons führen zur Ergebnis-Ansicht
        answerA.setOnClickListener(v -> goToResult(true));
        answerB.setOnClickListener(v -> goToResult(false));
        answerC.setOnClickListener(v -> goToResult(false));
        answerD.setOnClickListener(v -> goToResult(false));
    }

    private void goToResult(boolean isCorrect) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", isCorrect);
        startActivity(intent);
    }
}
