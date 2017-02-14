package com.example.basma.startpage;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by basma on 2/6/2017.
 */
public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        createNotification(context,"Times Up","5 Seconds Has Passed","Alert");
    }

    private void createNotification(Context context, String mesg, String mesgtext, String msgalert) {

        PendingIntent notificIntent=PendingIntent.getActivity(context,0,new Intent(context,AlertActivity.class),0);

        NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_alert)
                .setContentTitle(mesg)
                .setContentText(mesgtext).setTicker(msgalert);

        mBuilder.setContentIntent(notificIntent);
        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);

        NotificationManager mNotificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1,mBuilder.build());


    }
}
