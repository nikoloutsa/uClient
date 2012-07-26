package eu.uberdust.uClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import eu.uberdust.model.Room;

public class RoomActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        
        Intent i = getIntent();
        Room room = (Room)i.getSerializableExtra("MyRoom");
        Log.d("PASS",room.getCapability(0).getName());
        Log.d("PASS",room.getCapability(0).getValue());
        Log.d("PASS",room.getCapability(1).getName());
        Log.d("PASS",room.getCapability(1).getValue());
        Log.d("PASS",room.getCapability(2).getName());
        Log.d("PASS",room.getCapability(2).getValue());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_room, menu);
        return true;
    }
}
