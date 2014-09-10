package com.example.alex.emergancyhelp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends Activity {


    private static final int CHECK_SERVICES = 1;
    private Context mContext = MainActivity.this;
    private LocationManager lm;
    private ToggleButton btn1,btn2;
    private Button btnSend;
    private boolean isGPS,isNetwork,isPassive = false;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lm  = (LocationManager) getSystemService(LOCATION_SERVICE);
        btn1 = (ToggleButton) findViewById(R.id.btn_phone_book);
        btn2 = (ToggleButton) findViewById(R.id.btn_get_location);
        btnSend = (Button) findViewById(R.id.btnSend);


        if(softWarmServices() == true){
            warmServices();
        } else checkServices();


    }


    protected void warmServices(){
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 1.0f, (android.location.LocationListener) this);
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000L, 1.0f, (android.location.LocationListener) this);
        lm.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, 1000L, 1.0f, (android.location.LocationListener) this);

    }

    private boolean softWarmServices(){
        isGPS = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetwork = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        isPassive = lm.isProviderEnabled(LocationManager.PASSIVE_PROVIDER);
        if(isGPS == true || isNetwork == true || isPassive == true){
            return true;
        }
        return false;
    }

    private boolean checkServices(){
        if (isGPS == true){
            Toast.makeText(this,"Using GPS location", Toast.LENGTH_SHORT).show();
            return true;
        } else if (isNetwork == true){
            Toast.makeText(this,"Using Network location", Toast.LENGTH_SHORT).show();
            return true;
        } else if (isPassive == true){
            Toast.makeText(this,"Using Passive location", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), CHECK_SERVICES);
        }
        return false;
    }

    public void getPhoneBook(View view){
        Toast.makeText(this,"getPhoneBook",Toast.LENGTH_SHORT).show();
        btn2.setEnabled(true);
    }

    public void getDeviceLocation(View view){
        Toast.makeText(this,"getDeviceLocation",Toast.LENGTH_SHORT).show();
        btnSend.setEnabled(true);
    }

    public void initiateRequest(View view){
        Toast.makeText(this,"initiateRequest",Toast.LENGTH_SHORT).show();
        btn2.setEnabled(false);
        btnSend.setEnabled(false);
        btn1.setChecked(false);
        btn2.setChecked(false);
    }

















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
