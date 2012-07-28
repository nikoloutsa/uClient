package eu.uberdust.uClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import eu.uberdust.model.Capability;
import eu.uberdust.model.Room;



public class HomeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
            	
            	Room room1 = new Room();
            	Capability capa1 = new Capability();
            	Capability capa2 = new Capability();
            	Capability capa3 = new Capability();
            	capa1.setName("Temperature");
            	capa1.setValue("10");
            	capa1.setType(0);
            	capa2.setName("Light");
            	capa2.setValue("11");
            	capa2.setType(0);
            	capa3.setName("AC");
            	capa3.setType(1);
            	room1.appendCapability(capa1);
            	room1.appendCapability(capa2);
            	room1.appendCapability(capa3);
            	
            	Intent i = new Intent(getApplicationContext(), RoomActivity.class);
            	i.putExtra("MyRoom", room1);
            	startActivity(i);
            	/*IntentIntegrator integrator = new IntentIntegrator(HomeActivity.this);
            	integrator.initiateScan(IntentIntegrator.QR_CODE_TYPES);*/

    }


    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (result != null) {
          String contents = result.getContents();
          if (contents != null) {
            Log.d("SCAN",contents);
          } else {
        	  Log.d("SCAN","FAIL");
          }
        }
      }
    
    
}
