package mitchell.ShipIt;



import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;




import android.os.Bundle;
import android.view.MenuInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.TextView;

import com.actionbarsherlock.view.MenuItem;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

public class WellnessActivity extends SherlockActivity {
	
	String email; 
	String password; 
    private TextView text_edit;
    private DatePicker date_picker;
    private int month;
    private int day;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
			    WindowManager.LayoutParams.FLAG_FULLSCREEN);
				requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		
				setContentView(R.layout.activity_wellness);
				Intent i = getIntent();
				//User user = (User)i.getSerializableExtra("userobj");
				//getEvents(user);
				initDatePicker();

        }

  /*  private void getEvents(User current){
    	HashSet<Event> events = current.getCalendar().getEvents();
    	Iterator iter = events.iterator();

    	while (iter.hasNext()){
    		//maybe do something, maaaybe
    	}
    	
    }*/
    private void initDatePicker(){
        text_edit = (TextView) findViewById(R.id.editText1);
        date_picker = (DatePicker) findViewById(R.id.datePicker1);
 
         

    	
    }

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.wellness, menu);
		getSupportActionBar().setBackgroundDrawable(
				new ColorDrawable(Color.rgb(88, 196, 88)));
	
		return true;
	}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	//if (R.id.Group1 == item.getItemId())
    	return false;
    }
}