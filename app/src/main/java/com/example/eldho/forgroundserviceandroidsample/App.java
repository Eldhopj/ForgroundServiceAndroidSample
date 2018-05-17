package com.example.eldho.forgroundserviceandroidsample;
/**Create notification in Application Class
 * Register app class in Manifest file*/
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String CHANNEL_ID ="exampleServiceChannel";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // notification channel object
            //Parameters are channelID , channel Name , and the Importance of channel (Tip : keep importance minimum for persistence notification)
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,"Example Service Channel",
                    NotificationManager.IMPORTANCE_MIN
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }
}
