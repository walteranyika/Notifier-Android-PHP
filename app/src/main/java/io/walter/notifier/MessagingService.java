package io.walter.notifier;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessagingService extends FirebaseMessagingService {
    private static final String TAG = "MESSAGE_NOTIFIER";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "onMessageReceived: "+remoteMessage.getNotification().getBody());
        String text=remoteMessage.getNotification().getBody();
        Intent intent=new Intent(this, MainActivity.class);
        PendingIntent pIntent=PendingIntent.getActivity(this,2000,intent,0);

        Notification notification  = new Notification.Builder(this)
                                    .setContentTitle("Taxi has arrived")
                                    .setContentText(text)
                                    .setSmallIcon(R.drawable.ic_new_message)
                                    .setContentIntent(pIntent)
                                    .setAutoCancel(true).build();
        NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0,notification);

    }
}
