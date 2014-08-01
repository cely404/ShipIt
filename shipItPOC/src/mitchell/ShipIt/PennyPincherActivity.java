
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
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class PennyPincherActivity extends SherlockActivity
{
	Menu mymenu;
	
	List<String> categoryList;
	List<String> activityList;
	Map<String, List<String>> avtivityCollection;
	ExpandableListView expListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = getIntent().getExtras();
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setTitle("Temporary");

		setContentView( R.layout.activity_penny_pincher_activiy );
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
        createGroupList();
        
        createCollection();
 
        expListView = (ExpandableListView) findViewById(R.id.penny_pincher_list);
        final ExpandableListAdapter expListAdapter = new ExpandableListAdapter(
                this, categoryList, avtivityCollection);

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
        categoryList = new ArrayList<String>();
        categoryList.add("Broadway");
        categoryList.add("Movies");
        categoryList.add("Shopping");
        categoryList.add("Theme Parks");
        categoryList.add("E-Tickets");
        categoryList.add("Travel");
    }
 
    private void createCollection() {
        // preparing laptops collection(child)
        String[] broadway = { 
        		"If/Then (New York, NY): August 9, 2014 - Matinee : Save up to $14.25 per ticket",
                "Blue Man Group (New York, NY): August 16, 2014 - Matinee : Save up to $32.50 per ticket",
                "Kinky Boots (New York, NY): August 16, 2014 - Matinee",
                "The Lion, the Witch, and the Wardrobe (New York, NY) August 9, 2014 - Matinee : Save up to $20.00 per ticket",
                "A Gentlemans Guide to Love and Murder (New York, NY) September 6, 2014 - Matinee : Save up to $46.50 per ticket"
                };
        String[] movies = {
        		"Regal Premiere E-Ticket : ",
                "Regal VIP E-Ticket : No Delivery Fee - Limited Supply!",
                "AMC Gold E-Ticket : ",
                "Cinemark Platinum e-Supersaver : ",
                "The Redbox Card : Morwe than 35,900 locations nationwide!",
                "Bow Tie Cinemas : Save up to 29%"        		
        };
        String[] shopping = {
        		"Verizon Broadband Services : $400 Visa prepaid card with Verizon Fios Triple play",
                "getaroom : Exclusive VIP hotel rates up to 60% off! Not available to general public",
                "Rosetta Stone : Save $235 per set, plus free shipping",
                "Esurance : Auto Insurance: Save up to 28%",
                "AT&T U-verse: Digital TV, Internet & Voice : TV, Internet and Voice: $79 per month + $250 in reqard cards",
                "Liberty Mutual : Save up to $423 on Auto, Home and Renters Insurance"       		
        };
        String[] themeParks = {             "LegoLand California Resort Hopper Ticket : Save up to $33.00 per ticket",
                "Hershey park (Hershey, PA) : Save up to $19.40 per ticket",
                "DorneyParkandWildwaterKingdom(Allentown, PA) : ",
                "2DayParktoPark: UniversalOrlandoResort : Saveupto$42.74perticket",
                "KnottsBerryFarm(BuenaPark,CA) : Saveupto$28perticket",
                "SixFlagsgreatadventureandwildsafari(Jackson, NJ) : Save up to $31.70 per ticket"       		
        };
        String[] eTickets = {
                "LegoLandFlorida: 1DayE-ticket : Save up to $23.07 per ticket",
                "UniversalStudiosHollywood(UniversalCity, CA): 1Daywith2ndand3rdfree: E-ticket : Saveupto$10.00perticket",
                "SixFlagsGreatAdventureandwildsafari(Jackson, NJ): E-ticket : Saveupto$32.21perticket",
                "DorneyParkandWildwaterKingdon(Allentown, PA): E-ticket : ",
                "SeaWorld(SanDiego, CA): SingleDaywith2ndDayFreeE-ticket : Foralimitedtime, geta2nddayfree!"
        };
        String[] travel = {
                "Tampa: CityPASS : Save up to $79.55 off the cost of visiting attractions individually",
                "CarRentals.com : Rent a car from $16.95 a day",
                "CheapTickets : Extra 18% on hotels, Beach hotel deals - Save up to 50%, Hotels under $60, flight discounts",
                "Hertz : Exlusive: up to 25% your reservation plus additional hot deals",
                "Hotels.com : Save between $20 and $100 on all Hotel Bookings, Summer of Savings: Save up to 40%, Deal of the Day!",
                "Hilton Worldwide : Summer Sale! Up to 33% off across Europe, Middle Ease and Africa, Hilton, Doubletree, Embassy Suites, Hampton Inn Special Offers"
        };
 
        avtivityCollection = new LinkedHashMap<String, List<String>>();
 
        for (String category : categoryList) {
            if (category.equals("Broadway")) {
                loadChild(broadway);
            } else if (category.equals("Movies"))
                loadChild(movies);
            else if (category.equals("Shopping"))
                loadChild(shopping);
            else if (category.equals("Theme Parks"))
                loadChild(themeParks);
            else if (category.equals("E-Tickets") )
            	loadChild(eTickets);
            else if (category.equals("Travel"))
            	loadChild(travel);
 
            avtivityCollection.put(category, activityList);
        }
    }
 
    private void loadChild(String[] answers) {
        activityList = new ArrayList<String>();
        for (String model : answers)
            activityList.add(model);
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
        getSupportMenuInflater().inflate(R.menu.penny_pincher_activiy, menu);
        getSupportActionBar().setBackgroundDrawable(
				new ColorDrawable(Color.rgb(223, 160, 23)));
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
