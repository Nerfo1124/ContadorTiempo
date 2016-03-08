package co.com.udistrital.pantalla3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import co.com.udistrital.pantalla3.widgets.ProgressCircle;


public class Main2Activity extends AppCompatActivity {

    ProgressCircle progressCircle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        progressCircle = (ProgressCircle) findViewById(R.id.progress_circle);
        progressCircle.startAnimation();

    }

    public void off(View v){
        stopService(new Intent(Main2Activity.this, pantalla_on_off.class));
    }

    public void animate(View view) {
        try {
            if (Contador.tiempo.toString()!=""){
                String v[] = Contador.tiempo.split(":");
                int minutos = (Integer.parseInt(v[0]) * 60) + (Integer.parseInt(v[1]));
                float min= (float)minutos/720;
                progressCircle.setProgress(min);
                progressCircle.startAnimation();
                Toast.makeText(this, ""+min, Toast.LENGTH_LONG).show();
            } else{
                progressCircle.setProgress(0);
                progressCircle.startAnimation();
            }
        }catch (Exception ex){
            Toast.makeText(this,"Error:"+ex.getMessage().toString(),Toast.LENGTH_LONG).show();
        }
    }
}
