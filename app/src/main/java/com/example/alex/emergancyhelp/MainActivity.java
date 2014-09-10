package com.example.alex.emergancyhelp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends Activity {

    private ToggleButton btn1,btn2;
    private Button btnSend;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (ToggleButton) findViewById(R.id.btn_phone_book);
        btn2 = (ToggleButton) findViewById(R.id.btn_get_location);
        btnSend = (Button) findViewById(R.id.btnSend);
    }

    public void getPhoneBook(View view){
        Toast.makeText(this,"getDeviceLocation",Toast.LENGTH_SHORT).show();
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
