
package mitchell.ShipIt;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import not.activities.ExpandableListAdapter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class ImportantNumbersActivity extends SherlockActivity
{
	Menu mymenu;
	List<String> serviceList;
	List<String> numberList;
	Map<String, List<String>> importantNumberCollection;
	ExpandableListView expListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView( R.layout.activity_important_numbers );
		
		setTitle("Important Numbers");

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
        createGroupList();
        
        createCollection();
 
        expListView = (ExpandableListView) findViewById(R.id.numbers_list);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, serviceList, importantNumberCollection);

        expListView.setAdapter(expListAdapter);
 
        //setGroupIndicatorToRight();
 
        expListView.setOnChildClickListener(new OnChildClickListener() {
 
            public boolean onChildClick(ExpandableListView parent, View v,
                    int groupPosition, int childPosition, long id) {
                final String selected = (String) expListAdapter.getChild(
                        groupPosition, childPosition);
                Toast.makeText(getBaseContext(), selected, Toast.LENGTH_LONG)
                        .show();
 
                return true;
            }
        });

	}
	
	
	
    private void createGroupList() {
        serviceList = new ArrayList<String>();
        serviceList.add("serviceDesk");
        serviceList.add("customerService");
    }
 
    private void createCollection() {
        // preparing laptops collection(child)
        String[] serviceNumbers = { "6878-2" };
        String[] customerNumbers = { "1-800-565-3712" };
 
        importantNumberCollection = new LinkedHashMap<String, List<String>>();
 
        for (String service : serviceList) {
            if (service.equals("serviceDesk")) {
                loadChild(serviceNumbers);
            } else if (service.equals("customerService"))
                loadChild(customerNumbers);
 
            importantNumberCollection.put(service, numberList);
        }
    }
 
    private void loadChild(String[] numbers) {
        numberList = new ArrayList<String>();
        for (String model : numbers)
            numberList.add(model);
    }
 
    private void setGroupIndicatorToRight() {
        /* Get the screen width */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
 
        expListView.setIndicatorBounds(width - getDipsFromPixel(35), width
                - getDipsFromPixel(5));
    }
 
    // Convert pixel to dip
    public int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }
	
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.important_numbers, menu);
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

