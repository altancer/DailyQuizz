package de.th_nuernberg.bme.dailyquizz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {

    private String[][] questions;
    private int currentQuestion = 0;
    private int score = 0;
    private String selectedCategory;

    private TextView questionText;
    private Button answerA, answerB, answerC, answerD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        selectedCategory = getIntent().getStringExtra("category");

        questionText = findViewById(R.id.questionText);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        answerD = findViewById(R.id.answerD);

        questions = loadQuestionsByCategory(selectedCategory);
        loadQuestion();

        answerA.setOnClickListener(v -> checkAnswer("A"));
        answerB.setOnClickListener(v -> checkAnswer("B"));
        answerC.setOnClickListener(v -> checkAnswer("C"));
        answerD.setOnClickListener(v -> checkAnswer("D"));
    }

    private String[][] loadQuestionsByCategory(String category) {
        switch (category) {
            case "Geografie":
                return new String[][] {
                        {"Was ist die Hauptstadt von Frankreich?", "Paris", "Berlin", "Madrid", "Rom", "A"},
                        {"Welcher Kontinent ist am größten?", "Afrika", "Asien", "Europa", "Antarktis", "B"}
                };
            case "Tiere":
                return new String[][] {
                        {"Welches Tier ist ein Säugetier?", "Hai", "Pinguin", "Delfin", "Tintenfisch", "C"},
                        {"Welches Tier legt Eier?", "Hund", "Katze", "Ente", "Pferd", "C"}
                };
            case "Geschichte":
                return new String[][] {
                        {"Wann begann der Zweite Weltkrieg?", "1937", "1938", "1939", "1940", "C"},
                        {"Wer war Kaiser von Rom?", "Napoleon", "Caesar", "Hitler", "Sokrates", "B"}
                };
            case "Politik":
                return new String[][] {
                        {"Wer ist aktuell Kanzler Deutschlands?", "Merkel", "Scholz", "Laschet", "Baerbock", "B"},
                        {"Wie viele Parteien sind im Bundestag?", "3", "4", "5", "6", "D"}
                };
            default:
                return new String[][] {
                        {"Standardfrage?", "A", "B", "C", "D", "A"}
                };
        }
    }

    private void loadQuestion() {
        if (currentQuestion >= questions.length) {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("score", score);
            intent.putExtra("total", questions.length);
            startActivity(intent);
            finish();
            return;
        }

        String[] q = questions[currentQuestion];
        questionText.setText(q[0]);
        answerA.setText("A: " + q[1]);
        answerB.setText("B: " + q[2]);
        answerC.setText("C: " + q[3]);
        answerD.setText("D: " + q[4]);
    }

    private void checkAnswer(String selected) {
        String correct = questions[currentQuestion][5];
        if (selected.equals(correct)) {
            score++;
        }
        currentQuestion++;
        loadQuestion();
    }
}
