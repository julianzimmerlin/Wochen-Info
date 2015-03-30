package julianzimmerlin.wocheninfo;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.view.View;
import android.widget.RemoteViews;
import android.content.*;
import android.app.PendingIntent;
import android.widget.Toast;
import julianzimmerlin.wocheninfo.R;

import java.util.Calendar;


/**
 * Implementation of App Widget functionality.
 */
public class MyAppWidget extends AppWidgetProvider {

    public static String GUTE_AKTION = "GuteAktion";
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        final int N = appWidgetIds.length;
        for (int i = 0; i < N; i++) {
            updateAppWidget(context, appWidgetManager, appWidgetIds[i]);

            Intent intent = new Intent(context, MainActivity.class);
            intent.setAction(GUTE_AKTION);

            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            // Get the layout for the App Widget and attach an on-click listener to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_app_widget);
            views.setOnClickPendingIntent(R.id.rellay, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetIds[i], views);
        }
    }


    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        Calendar c = Calendar.getInstance();
        int wochenzahl = c.get(Calendar.WEEK_OF_YEAR);
        CharSequence widgetText = wochenzahl + "";
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_app_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

}


