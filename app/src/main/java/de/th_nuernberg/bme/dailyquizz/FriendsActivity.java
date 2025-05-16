package de.th_nuernberg.bme.dailyquizz;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FriendsActivity extends AppCompatActivity {

    private String[] friends = {"Amira", "Leon", "Sara"};
    private int[] points = {120, 85, 69};

    private TextView friendNameText;
    private TextView friendPointsText;
    private View detailBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        ListView listView = findViewById(R.id.friendListView);
        detailBox = findViewById(R.id.detailBox);
        friendNameText = findViewById(R.id.friendNameText);
        friendPointsText = findViewById(R.id.friendPointsText);
        Button challengeBtn = findViewById(R.id.challengeBtn);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, friends);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            friendNameText.setText("Freund: " + friends[position]);
            friendPointsText.setText(points[position] + " Punkte");
            detailBox.setVisibility(View.VISIBLE);
        });

        challengeBtn.setOnClickListener(v -> {
            // Dummy-Action
            detailBox.setVisibility(View.GONE);
        });
    }
}
