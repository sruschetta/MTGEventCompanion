package vectis.mtgeventcompanion;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.RunnableFuture;


public class MainActivity extends AppCompatActivity implements CTimerListener{

    private ArrayList<String> players;

    private CTimer timer;

    private TextView counterView;

    public MainActivity() {

        players = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            players.add("Player " + i);
        }

        timer = new CTimer(20, this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterView = (TextView) findViewById(R.id.count_textview);

        timer.startTimer();

        //ListView playerList = (ListView) findViewById(R.id.player_list);

        //PlayersAdapter playerAdapter = new PlayersAdapter(this, R.layout.player_list_item, players);
        //playerList.setAdapter(playerAdapter);
    }


    /*--- CTimer Listener ---*/

    @Override
    public void countdown(int count) {
    }

    @Override
    public void countdownEnded() {
    }

    /*

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

    */
}
