package de.th_nuernberg.bme.dailyquizz;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class FriendsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        ListView friendList = findViewById(R.id.friendListView);

        String[] friends = {"Amira – 120 Punkte", "Leon – 85 Punkte", "Sara – 69 Punkte"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                friends
        );

        friendList.setAdapter(adapter);
    }
}
