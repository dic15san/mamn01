package se.example.stinaandreason.helloapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class AccelerometersActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    TextView txt_x;
    TextView txt_y;
    TextView txt_z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometers);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        txt_x= (TextView) findViewById(R.id.txt_x);
        txt_y= (TextView) findViewById(R.id.txt_y);
        txt_z= (TextView) findViewById(R.id.txt_z);

    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        DecimalFormat df = new DecimalFormat(  "0.00");

        txt_x.setText("X: " + df.format(event.values[0]));
        txt_y.setText("Y: " + df.format(event.values[1]));
        txt_z.setText("Z: " + df.format(event.values[2]));
    }
}
