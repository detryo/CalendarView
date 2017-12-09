package cristian_sedano.calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Christian on 03/12/2017.
 */

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note_activity);

        final com.applandeo.materialcalendarview.CalendarView datePicker = (com.applandeo.materialcalendarview.CalendarView) findViewById(R.id.datePicker);
        Button button = (Button) findViewById(R.id.addNoteButton);
        final EditText noteEditText = (EditText) findViewById(R.id.noteEditText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                MyEventDay myEventDay = new MyEventDay(datePicker.getSelectedDate(), R.drawable.ic_arrow_left, noteEditText.getText().toString());
                returnIntent.putExtra(MainActivity.RESULT, myEventDay);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}