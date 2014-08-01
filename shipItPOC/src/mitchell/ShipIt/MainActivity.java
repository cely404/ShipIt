
package mitchell.ShipIt;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockActivity
{
Menu mymenu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		setTitle("Information Stronghold");

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.activity_main, menu);
        getSupportActionBar().setBackgroundDrawable(
				new ColorDrawable(Color.rgb(50, 113, 238)));
		mymenu = menu;
        return true;
    }
    
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.melvinsMenu: {
				Intent i = new Intent(this, MelvinMenu.class); 
				startActivity(i);
				break;
			}
			case R.id.localGrub: {
				Intent i = new Intent(this, LocalGrubActivity.class); 
				startActivity(i);
				break;
			}
			case R.id.wellness: {
				Intent i = new Intent(this, WellnessActivity.class); 
				startActivity(i);
				break;
			}
			case R.id.maps: {
				Intent i = new Intent(this, MapsActivity.class); 
				startActivity(i);
				break;
			}
			case R.id.pennyPincher: {
				Intent i = new Intent(this, PennyPincherActivity.class); 
				startActivity(i);
				break;
			}
			case R.id.importantNumbers: {
				Intent i = new Intent(this, ImportantNumbersActivity.class); 
				startActivity(i);
				break;
			}
			case R.id.faq: {
				Intent i = new Intent(this, FAQActivity.class); 
				startActivity(i);
				break;
			}

		}
		return false;

	}
}
