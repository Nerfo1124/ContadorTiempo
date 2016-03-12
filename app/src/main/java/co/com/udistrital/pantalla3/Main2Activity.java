package co.com.udistrital.pantalla3;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import co.com.udistrital.pantalla3.widgets.ProgressCircle;


public class Main2Activity extends AppCompatActivity {

    ProgressCircle progressCircle;
    TextView t;
    MyTask myTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        progressCircle = (ProgressCircle) findViewById(R.id.progress_circle);
        progressCircle.startAnimation();
        t=(TextView)findViewById(R.id.textView);
        myTask = new MyTask();
        myTask.execute();

    }

    public void off(View v){
        stopService(new Intent(Main2Activity.this, pantalla_on_off.class));
    }

    public void animate(View view) {
                Toast.makeText(this, "TE AMO", Toast.LENGTH_LONG).show();
    }

    private class MyTask extends AsyncTask<String, String, String> {

        private boolean cent;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            cent = true;
        }

        @Override
        protected String doInBackground(String... params) {
            while (cent){
                try {
                    if (Contador.tiempo.toString()!=""){
                        String v[] = Contador.tiempo.split(":");
                        int minutos = (Integer.parseInt(v[0]) * 60) + (Integer.parseInt(v[1]));
                        float min= (float)minutos/720;
                        publishProgress(""+min);
                    } else{
                        publishProgress(""+0);
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            progressCircle.setProgress(Float.parseFloat(values[0]));
            progressCircle.startAnimation();
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            cent = false;
        }
    }





}
