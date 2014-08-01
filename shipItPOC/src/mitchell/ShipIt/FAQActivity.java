
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
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class FAQActivity extends SherlockActivity
{
	Menu mymenu;
	
	List<String> questionList;
	List<String> answerList;
	Map<String, List<String>> faqCollection;
	ExpandableListView expListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView( R.layout.activity_faq );
		
		setTitle("FAQ");

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        createGroupList();
        
        createCollection();
 
        expListView = (ExpandableListView) findViewById(R.id.faq_list);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, questionList, faqCollection);

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
        questionList = new ArrayList<String>();
        questionList.add("Who should I call for help?");
        questionList.add("Where can I find a restroom?");
        questionList.add("Can I eat the fruit in the lobby?");
        questionList.add("Does it cost anything?");
    }
 
    private void createCollection() {
        // preparing laptops collection(child)
        String[] whoToCall = { "Ghost Busters" };
        String[] whatIsTheCost = { "No" };
        String[] canIEat = { "Yes" };
        String[] whereToPee = { "Just look for the striped walls" };
 
        faqCollection = new LinkedHashMap<String, List<String>>();
 
        for (String question : questionList) {
            if (question.equals("Who should I call for help?")) {
                loadChild(whoToCall);
            } else if (question.equals("Where can I find a restroom?"))
                loadChild(whereToPee);
            else if (question.equals("Can I eat the fruit in the lobby?"))
                loadChild(canIEat);
            else if (question.equals("Does it cost anything?"))
                loadChild(whatIsTheCost);
 
            faqCollection.put(question, answerList);
        }
    }
 
    private void loadChild(String[] answers) {
        answerList = new ArrayList<String>();
        for (String model : answers)
            answerList.add(model);
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
        getSupportMenuInflater().inflate(R.menu.faq, menu);
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

