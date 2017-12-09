package cristian_sedano.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.applandeo.materialcalendarview.EventDay;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Christian on 03/12/2017.
 */

public class NotePreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_preview_activity);

        TextView note = (TextView) findViewById(R.id.note);
        Intent intent = getIntent();
        if (intent != null) {
            Object event = intent.getParcelableExtra(MainActivity.EVENT);
            if(event instanceof MyEventDay){
                MyEventDay myEventDay = (MyEventDay)event;
                getSupportActionBar().setTitle(getFormatdDate(myEventDay.getCalendar().getTime()));
                note.setText(myEventDay.getNote());
                return;
            }
            if(event instanceof EventDay){
                EventDay eventDay = (EventDay)event;
                getSupportActionBar().setTitle(getFormatdDate(eventDay.getCalendar().getTime()));
            }
        }
    }
    public static String getFormatdDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        return simpleDateFormat.format(date);
    }
}