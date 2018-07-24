package com.example.sjonqui.ecowidget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Created by sjonqui on 23/07/18.
 */

public class EcoWidgetProvider extends AppWidgetProvider {
/*

    public static void sendRefreshBroadcast(Context context){
        Intent intent=new Intent(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        intent.setComponent(new ComponentName(context, EcoWidgetProvider.class));
        context.sendBroadcast(intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //context.startService(new Intent(context,EcoWidgetService.class));


        for(int appWidgetId: appWidgetIds){
            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.ecowidget_layout);
            //Intent intent = new Intent(context,MyWidgetRemoteViewsService.class);
            Intent intent = new Intent(context,EcoWidgetService.class);
            views.setRemoteAdapter(R.layout.news_layout, intent);
            appWidgetManager.updateAppWidget(appWidgetId,views);
        }

*/
/*        ComponentName thisWidget = new ComponentName(context,
                EcoWidgetProvider.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
        for (int widgetId : allWidgetIds) {
            // create some random data
            int number = (new Random().nextInt(100));

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                    R.layout.ecowidget_layout);
            Log.w("WidgetExample", String.valueOf(number));
            // Set the text
            remoteViews.setTextViewText(R.id.txt_dia, String.valueOf(number));

            // Register an onClickListener
            Intent intent = new Intent(context, EcoWidgetProvider.class);

            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
                    0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.txt_dia, pendingIntent);
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
        *//*


    }

    @Override
    public void onReceive(Context context,Intent intent){
        final String action = intent.getAction();
        if (action.equals(AppWidgetManager.ACTION_APPWIDGET_UPDATE)){
            AppWidgetManager mgr= AppWidgetManager.getInstance(context);
            ComponentName cn= new ComponentName(context, EcoWidgetProvider.class);
            mgr.notifyAppWidgetViewDataChanged(mgr.getAppWidgetIds(cn),R.id.newsView);
        }
        super.onReceive(context,intent);
    }
}
*/

    private PendingIntent service;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        final Intent i = new Intent(context, EcoWidgetService.class);

        if (service == null) {
            service = PendingIntent.getService(context, 0, i, PendingIntent.FLAG_CANCEL_CURRENT);
        }
        manager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), 60000, service);
    }
}