package com.example.sjonqui.ecowidget;

import android.app.IntentService;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.Context;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.widget.RemoteViews;

import java.util.ArrayList;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class EcoWidgetService extends Service {

    private static String ACTION_DO_UPDATE = "actionDoUpdate";




    @Override
    public int onStartCommand(Intent intent,int flags, int startId){
        RemoteViews view = new RemoteViews(getPackageName(), R.layout.news_layout);
        view.setTextViewText(R.id.detail,"HOALSDSA");
        ComponentName theWidget = new ComponentName(this, EcoWidgetProvider.class);
        AppWidgetManager manager = AppWidgetManager.getInstance(this);
        manager.updateAppWidget(theWidget, view);

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public static void startActionUpdate(Context context) {


    }


}