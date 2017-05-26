package sg.edu.rp.c346.demoalarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar; // choose the second one

public class MainActivity extends AppCompatActivity {

    Button btnSetAlarm;
    AlarmManager am;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetAlarm = (Button)findViewById(R.id.btnAlarm);

        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // choose second import as first is for api >24
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, 5);

                // create a new PendingIntent and add it to the AlarmManger
                Intent intent = new Intent(MainActivity.this,AlarmRecieverActivity.class);
                int reqCode = 12345;
                PendingIntent pendingIntent= PendingIntent.getActivity(MainActivity.this,reqCode,intent,PendingIntent.FLAG_CANCEL_CURRENT);

                // Get AlarmManager instance
                am = (AlarmManager)getSystemService(Activity.ALARM_SERVICE);

                // Set the alarm
                am.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pendingIntent);

            }
        });
    }
}
