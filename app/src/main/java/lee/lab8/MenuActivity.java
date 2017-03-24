package lee.lab8;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

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
        switch(item.getItemId()) {
            case R.id.menu_yes_no: {
                return true;
            }
            case R.id.add: {
                return true;
            }
            case R.id.calendar: {
                return true;
            }
            case R.id.about: {
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    // Create an alias for our Activity to use in inner classes.
    final Activity activity = this;

    // Builder: create the builder and setup the title of the dialog.
    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
    builder.setTitle("STUB TITLE");

    // Builder: .... customize the dialog (see subsections)

    // Instanciate the dialog, and show it (here I also disable the automatic keyboard pop-up, like
    // we’ve seen in the List View lab).
    AlertDialog dialog = builder.create();
    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    dialog.show();
}
