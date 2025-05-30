package de.th_nuernberg.bme.dailyquizz;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class RankingActivity extends AppCompatActivity {

    private ListView rankingList;
    private String[] global = {
            "1. Max – 300 Punkte",
            "2. Sarah – 270 Punkte",
            "3. Hiro – 250 Punkte"
    };

    private String[] local = {
            "1. Leon – 180 Punkte",
            "2. Amira – 165 Punkte",
            "3. Cem – 140 Punkte"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        rankingList = findViewById(R.id.rankingList);
        RadioGroup group = findViewById(R.id.rankTypeGroup);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                global
        );
        rankingList.setAdapter(adapter);

        group.setOnCheckedChangeListener((radioGroup, id) -> {
            if (id == R.id.globalBtn) {
                rankingList.setAdapter(new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, global));
            } else {
                rankingList.setAdapter(new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, local));
            }
        });
    }
}
