package julianzimmerlin.wocheninfo;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.util.Calendar;


/**
 * Implementation of App Widget functionality.
 */
public class MyAppWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            Calendar c = Calendar.getInstance();
            int wochenzahl = c.get(Calendar.WEEK_OF_YEAR);
            // Construct the RemoteViews object
            // Get the layout for the App Widget and attach an on-click listener to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_app_widget);
            views.setTextViewText(R.id.appwidget_text, wochenzahl + "");
            views.setOnClickPendingIntent(R.id.rellay, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }


    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

}


