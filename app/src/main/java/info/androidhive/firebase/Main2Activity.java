package info.androidhive.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    String TAG="Main2";
    private Gps gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void clickEvent (View view)
    {
        Log.i(TAG,"on click event");
        gps = new Gps(this);

        // check if GPS enabled
        if(gps.canGetLocation()){

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
            long time=gps.getTime();

            // \n is for new line
            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " +""+latitude + "\nLong: " + longitude+"\n time:"+time,Toast.LENGTH_LONG).show();

            Log.e("Time",""+time);

            getDateCurrentTimeZone(time);
        }else{
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }

    }

    public  String getDateCurrentTimeZone(long timestamp) {
        try{


            String time = DateUtils.formatDateTime(this, timestamp, DateUtils.FORMAT_SHOW_TIME);
            Log.e("Time",""+time);


            String date =  DateUtils.formatDateTime(this, timestamp, DateUtils.FORMAT_SHOW_DATE);
            Log.e("date",""+date);




        }catch (Exception e) {
        }
        return "";
    }

    }

