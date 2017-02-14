package com.example.basma.startpage;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.GregorianCalendar;


public class AlertActivity extends AppCompatActivity {

    boolean isNotificative=false;
    int notifId=33;
    NotificationManager notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        Button  ShowNotification=(Button)findViewById(R.id.show);
        Button  StopNotification=(Button)findViewById(R.id.stop);
        Button  alert=(Button)findViewById(R.id.alert);

        /*

          NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_alert)
                        .setContentTitle("Notifications Example")
                        .setContentText("This is a test notification");

        Intent notificationIntent = new Intent(this, AlertActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());

*/

    }


    public void ShowNotification(View view) {

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_alert)
                .setContentTitle("Message")
                .setContentText("New Message").setTicker("Alert New message");

        Intent moreInfoIntent = new Intent(this, MoreNotification.class);
        TaskStackBuilder taskstack=TaskStackBuilder.create(this);
        taskstack.addParentStack(MoreNotification.class);
        taskstack.addNextIntent(moreInfoIntent);

        PendingIntent pendingIntent = taskstack.getPendingIntent( 0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notifId,builder.build());

        isNotificative=true;
    }

    public void StopNotification(View view) {

        if(isNotificative)
        {
            notificationManager.cancel(notifId);
        }
    }



    public void SetAlarm(View view) {
        Long alerttime=new GregorianCalendar().getTimeInMillis()+5*1000;
        Intent alertIntent=new Intent(this,AlertReceiver.class);

        AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,alerttime,PendingIntent.getBroadcast(this,1,
                alertIntent,PendingIntent.FLAG_UPDATE_CURRENT));
    }
}
