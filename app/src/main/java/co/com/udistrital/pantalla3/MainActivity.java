package co.com.udistrital.pantalla3;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(MainActivity.this, pantalla_on_off.class));
    }

    public void on (View v){
        startService(new Intent(MainActivity.this, pantalla_on_off.class));
    }

    public void off(View v){
        stopService(new Intent(MainActivity.this, pantalla_on_off.class));
    }

    public void ventana(View v){
        Intent i= new Intent(this,Main2Activity.class);
        startActivity(i);
        this.finish();
    }
}
