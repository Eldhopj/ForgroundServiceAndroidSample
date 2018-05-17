package com.example.eldho.forgroundserviceandroidsample;

/** Its important to note that*/
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

public class ServiceClass extends Service {


    @Override
    //This will trigger when we start our service , this will occur many times
    public int onStartCommand(Intent intent, int flags, int startId) {

        String input = intent.getStringExtra(MainActivity.SERVICE_INTENT_NAME); // getting the passed intent value

        /**Notification */
        //Set Intent in a notification we have to use a pending intent
        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0); //Flag justify what happen when we update the pending intent

        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_ID)
                .setContentTitle("Example service") //Notification title
                .setContentText(input) //Text
                .setSmallIcon(R.drawable.ic_android_black_24dp) //icon
                .setContentIntent(pendingIntent) // intent
                .build();
        startForeground(1,notification);

        //if the work finishes the stopSelf method execute and quit the service
       // stopSelf();

        return START_REDELIVER_INTENT; // check other start deliver intent and use appropriate START DELIVERY INTENT

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    // Bind service is used to communicate back and forth by binding to it
    public IBinder onBind(Intent intent) {
        return null; // no need this method for us in this app so we keeping null here



    }
}
