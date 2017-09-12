package vectis.mtgeventcompanion;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<String> players;

    public MainActivity() {

        players = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            players.add("Player " + i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView playerList = (ListView) findViewById(R.id.player_list);

        PlayersAdapter playerAdapter = new PlayersAdapter(this, R.layout.player_list_item, players);
        playerList.setAdapter(playerAdapter);
    }


    private class PlayersAdapter extends ArrayAdapter<String> {

        public ArrayList<String> playersList;

        public PlayersAdapter(Context context, int resource, ArrayList<String> playersList) {
            super(context, resource, players);
            this.playersList = playersList;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            String player = playersList.get(position);

            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.player_list_item, parent, false);
            }

            TextView textView = convertView.findViewById(R.id.player_name);
            textView.setText(player);
            Log.d("here", textView.getText().toString());
            return convertView;
        }

        @Override
        public int getCount() {
            return playersList.size();
        }
    }
}
