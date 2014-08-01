
package mitchell.ShipIt;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;


public class MelvinMenu extends SherlockActivity
{
	Button monday, tuesday, wednesday, thursday, friday, local;
	TextView mytext;
	Menu mymenu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_melvin_menu);
		setTitle("The Melvin Menu");

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		monday = (Button) findViewById(R.id.button1);
		tuesday = (Button) findViewById(R.id.button2);
		wednesday = (Button) findViewById(R.id.button3);
		thursday = (Button) findViewById(R.id.button4);
		friday = (Button) findViewById(R.id.button5);
		local = (Button) findViewById(R.id.button6);
		mytext = (TextView) findViewById(R.id.editText1);
		
        monday.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	mytext.setText("its monday");
            	
            }
        });
        tuesday.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	mytext.setText("its tuesday");

            }
        });
        wednesday.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	mytext.setText("its wednesday");

            }
        });
        thursday.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	mytext.setText("its thursday");

            }
        });
        friday.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	mytext.setText("its friday");

            }
        });
        local.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
				//Intent i;
				//i=new Intent(this, LocalGrubActivity.class);
				//startActivity(i);
            	mytext.setText("I will display local restaurants");

            }
        });


	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.melvin_menu, menu);
        getSupportActionBar().setBackgroundDrawable(
				new ColorDrawable(Color.rgb(50, 113, 238)));
		mymenu = menu;
        return true;
    }
    
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			//case R.id.play_icon: {}
			default: {}
			return false;
			}

	}
}
