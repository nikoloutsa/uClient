package eu.uberdust.uClient;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.actionbarsherlock.view.MenuItem;
import eu.uberdust.uClient.R.id;



public class HomeActivity extends SherlockActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        final Button button = (Button) findViewById(R.id.scan_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	IntentIntegrator integrator = new IntentIntegrator(HomeActivity.this);
            	integrator.initiateScan(IntentIntegrator.QR_CODE_TYPES);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	getSupportMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case id.menu_home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
