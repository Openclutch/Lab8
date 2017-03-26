package lee.lab8;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflate the description of your menu items in the menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        // Create an alias for our Activity to use in inner classes.
        final Activity activity = this;

        switch(item.getItemId()) {
            case R.id.menu_yes_no: {

                // Good meh bad pop up

                // Builder: create the builder and setup the title of the dialog.
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("How is your day?");

                // Builder: .... customize the dialog (see subsections)
                // Good meh bad configuration
                builder.setMessage("How your day is going so far?");
                builder.setPositiveButton("Good", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TextView answer = (TextView) findViewById(R.id.answer_day_going);
                        answer.append("Good! "); // to set the text
                    }
                });
                builder.setNeutralButton("Meh", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TextView answer = (TextView) findViewById(R.id.answer_day_going);
                        answer.append("Meh... "); // to set the text
                    }
                });
                builder.setNegativeButton("Bad", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TextView answer = (TextView) findViewById(R.id.answer_day_going);
                        answer.append("Bad. "); // to set the text
                    }
                });

                // Builder: setup a listener for when the dialog is
                // cancelled (e.g. back button, click outside the box).

                builder.setOnCancelListener(
                    new DialogInterface.OnCancelListener() {
                        public void onCancel(DialogInterface dialog) {
                            TextView answer = (TextView) findViewById(R.id.answer_day_going);
                            answer.append("You don't care... "); // to set the text
                        }
                    }
                );

                // Instanciate the dialog, and show it
                // (here I also disable the automatic keyboard pop-up, like
                // we’ve seen in the List View lab).
                AlertDialog dialog = builder.create();
                dialog.getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                dialog.show();

                return true; // not sure why we do this but we do.
            }
            case R.id.add: {

                // Number picker popup

                // Builder: create the builder and setup the title of the dialog.
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Number picker");

                // Builder: .... customize the dialog (see subsections)
                // configure a number picker
                final NumberPicker picker = new NumberPicker(activity);
                picker.setMinValue(0);
                picker.setMaxValue(10);
                picker.setValue(5);
                picker.setWrapSelectorWheel(false); // just to show you it’s an option
                // make the picker the view of our dialog and handle the result
                builder.setView(picker);
                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int number = picker.getValue();
                        TextView answer = (TextView) findViewById(R.id.answer_number);
                        answer.append(String.valueOf(number) + " "); // to set the text
                    }
                } );

                // Instanciate the dialog, and show it
                AlertDialog dialog = builder.create();
                dialog.getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                dialog.show();

                return true;
            }
            case R.id.calendar: {

                // Date picker

                // Builder: create the builder and setup the title of the dialog.
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Date picker");

                // Builder: .... customize the dialog (see subsections)
                // configure a picker
                final DatePicker picker = new DatePicker(activity);
                picker.updateDate(1999, 11, 31); // note: month is zero based
                // make the picker the view of our dialog and handle the result
                builder.setView(picker);
                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int year = picker.getYear();
                        int month = picker.getMonth();
                        int day = picker.getDayOfMonth();
                        TextView answer = (TextView) findViewById(R.id.answer_calendar);
                        answer.append(String.valueOf(year) +
                                "/" + String.valueOf(month + 1) +
                                "/" + String.valueOf(day) + " ");
                    } });

                // Instanciate the dialog, and show it
                AlertDialog dialog = builder.create();
                dialog.getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                dialog.show();

                return true;
            }
            case R.id.about: {

                // About popup

                // Builder: create the builder and setup the title of the dialog.
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("About popup");

                // Builder: .... customize the dialog (see subsections)
                // inflate our about box layout
                LayoutInflater li = LayoutInflater.from(activity);
                View view = li.inflate(R.layout.custom_dialog, null);
                // set it as the main view
                builder.setView(view);
                // let the builder know that we want a ok button
                builder.setPositiveButton(android.R.string.ok, null);
                // a null listener defaults to dismissing the dialog.

                // Instanciate the dialog, and show it
                AlertDialog dialog = builder.create();
                dialog.getWindow().setSoftInputMode(
                        WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                dialog.show();

                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
