package de.th_nuernberg.bme.dailyquizz;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class RankingActivity extends AppCompatActivity {

    private String[] globalRanking = {
            "1. Max – 300 Punkte",
            "2. Sarah – 270 Punkte",
            "3. Hiro – 250 Punkte"
    };

    private String[] localRanking = {
            "1. Leon (Nürnberg) – 180 Punkte",
            "2. Amira (Nürnberg) – 165 Punkte",
            "3. Cem (Fürth) – 140 Punkte"
    };

    private ListView rankingList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        rankingList = findViewById(R.id.rankingList);
        RadioGroup rankTypeGroup = findViewById(R.id.rankTypeGroup);
        RadioButton globalBtn = findViewById(R.id.globalBtn);

        // Standardmäßig: global anzeigen
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, globalRanking);
        rankingList.setAdapter(adapter);

        rankTypeGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.globalBtn) {
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, globalRanking);
            } else {
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, localRanking);
            }
            rankingList.setAdapter(adapter);
        });
    }
}
