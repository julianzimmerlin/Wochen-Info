package julianzimmerlin.wocheninfo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;



public class MainActivity extends Activity {

    TextView woche;
    TextView datum;
    TextView parity;
    TextView text;
    View bg;
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
        rand = new Random();
        //mp = MediaPlayer.create(this, R.raw.sample);

        setDates();
    }

    @Override
    protected void onResume() {
        super.onResume();

        setBackground();
    }

    private void setDates() {
        Calendar c = Calendar.getInstance();
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

    private void setBackground() {
        int a = rand.nextInt(5);
        switch (a) {
            case 0:
                bg.setBackgroundResource(R.color.blue);
                break;
            case 1:
                bg.setBackgroundResource(R.color.cyan);
                break;
            case 2:
                bg.setBackgroundResource(R.color.red);
                break;
            case 3:
                bg.setBackgroundResource(R.color.yellow);
                break;
            case 4:
                bg.setBackgroundResource(R.color.purple);
                break;
            default:
                //bg.setBackgroundResource(R.color.blue);
        }
    }
}
