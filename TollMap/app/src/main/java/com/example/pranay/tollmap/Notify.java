package com.example.pranay.tollmap;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by samjadha on 9/21/16.
 */
public class Notify {
    public void issueNotification(String type, String title, String desc, Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);

        Intent clickIntent = null;
        Intent buyIntent = null;
//        Intent dismissIntent = new Intent(context, PingService.class);
//        dismissIntent.setAction(CommonConstants.ACTION_SNOOZE);
        String buyButton = "";
        String dismissButton = "";

        switch (type) {
            case "MONUMENT": {
                clickIntent = new Intent(context, BuyTickets.class);
                buyIntent = new Intent(context, BuyTickets.class);
                buyButton ="Buy";
                dismissButton = "Later";
                mBuilder.setSmallIcon(R.drawable.tajmahal);

                break;
            }
            case "TOLL": {
//                clickIntent = new Intent(context, PayTollDetailsActivity.class);
//                buyIntent = new Intent(context, PayTollDetailsActivity.class);
//                buyButton = context.getResources().getString(R.string.pay);
//                dismissButton = context.getResources().getString(R.string.later);
//                mBuilder.setSmallIcon(R.drawable.toll);

                break;
            }
            case "P2P": {
//                clickIntent = new Intent(context, BuyTickets.class);
//                buyIntent = new Intent(context, BuyTickets.class);
//                buyButton = context.getResources().getString(R.string.pay);
//                dismissButton = context.getResources().getString(R.string.later);
//                mBuilder.setSmallIcon(R.drawable.person);

                break;
            }
        }

        PendingIntent clickPendingIntent = PendingIntent.getActivity(context, 0, clickIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        PendingIntent buyPendingIntent = PendingIntent.getActivity(context, 0, buyIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        //PendingIntent dismissPendingIntent = PendingIntent.getService(context, 0, dismissIntent, 0);

        mBuilder.setContentTitle(title);
        mBuilder.setContentInfo(desc);
        mBuilder.setContentIntent(clickPendingIntent);
        mBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(desc));
        mBuilder.addAction(R.drawable.buy, buyButton, buyPendingIntent);
//                .addAction(R.drawable.cancel, dismissButton, dismissPendingIntent);
        int NOTIFICATION_ID = 1;
        Notification mNotification = mBuilder.build();

        notificationManager.notify(NOTIFICATION_ID, mNotification);
    }

}
