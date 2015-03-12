package julianzimmerlin.wocheninfo;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;



public class MainActivity extends ActionBarActivity {

    TextView woche;
    TextView datum;
    TextView parity;
    TextView text;
    View bg;
    Calendar c;
    MediaPlayer mp;
    Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        woche = (TextView) findViewById(R.id.blabla);
        datum = (TextView) findViewById(R.id.textView3);
        parity = (TextView) findViewById(R.id.textView2);
        text = (TextView) findViewById(R.id.textView);
        bg = findViewById(R.id.layout);
        c = Calendar.getInstance();
        rand = new Random();
        //mp = MediaPlayer.create(this, R.raw.sample);
    }

    @Override
    protected void onResume() {
        super.onResume();

        int a = rand.nextInt(4);
        switch (a) {
            case 0:
                bg.setBackgroundColor(Color.rgb(39, 176, 245));
                break;
            case 1:
                bg.setBackgroundColor(Color.rgb(207, 37, 187));
                break;
            case 2:
                bg.setBackgroundColor(Color.rgb(214, 211, 0));
                break;
            case 3:
                bg.setBackgroundColor(Color.rgb(224, 83, 27));
                break;
            case 4:
                bg.setBackgroundColor(Color.rgb(25, 224, 178));
                break;
            default:
                //bg.setBackgroundColor(Color.rgb(214, 211, 0));
        }

        c = Calendar.getInstance();
        int wochenzahl = c.get(Calendar.WEEK_OF_YEAR);
        String sprache = Locale.getDefault().getLanguage();
        String ordinal = "";
        switch (sprache) {
            case "en":
                if (wochenzahl % 100 == 11) ordinal = "th";
                else if (wochenzahl % 100 == 12) ordinal = "th";
                else if (wochenzahl % 10 == 1) ordinal = "st";
                else if (wochenzahl % 10 == 2) ordinal = "nd";
                else ordinal = "th";
                break;
            case "es":
                ordinal = "°";
                break;
            case "de":
                ordinal = ".";
                break;
        }
        woche.setText(wochenzahl + ordinal + " " + getString(R.string.woche) + ".");

        if(wochenzahl % 2 == 0) parity.setText("(" + getString(R.string.gerade) + ")");
        else parity.setText("(" + getString(R.string.ungerade) + ")");

        DateFormat df2 = new SimpleDateFormat("dd.MM.yyyy");
        datum.setText(df2.format(c.getTime()));
    }
}
