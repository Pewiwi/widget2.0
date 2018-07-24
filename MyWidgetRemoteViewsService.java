package com.example.sjonqui.ecowidget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by sjonqui on 24/07/18.
 */

public class MyWidgetRemoteViewsService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new MyWidgetRemoteViewsFactory(this.getApplicationContext(),intent);
    }
}
