
package mitchell.ShipIt;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MapsActivity extends SherlockActivity
{
	Menu mymenu;
	ImageView image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setTitle("Maps");

	    WebView mWebView=new WebView(MapsActivity.this);
	    mWebView.getSettings().setJavaScriptEnabled(true);
	    mWebView.loadUrl("http://acsweb.ucsd.edu/~dcduncan/mitchellMap/");
	    setContentView(mWebView);
		

		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.maps, menu);
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

