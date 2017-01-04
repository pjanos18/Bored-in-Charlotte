package com.example.paul.boredincharlotte;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {

    private String[] navigationOptions = {
            "Homepage",
            "What to do",
            "Food & Drinks",
            "Charlotte Neighborhoods",
            "History/Historical Places",
            "Public Transportation",
            "Surrounding Area",
            "Sports",
            "Other Sources",
            "Happening This Week"
    };
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  /*      Event sampleEvent = new Event("Jam", "Jam with my friends");

        Fragment fragment = new EventFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", sampleEvent.getName());
        bundle.putString("description", sampleEvent.getDescription());

        fragment.setArguments(bundle); */

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, navigationOptions));

        Fragment defaultFragment = new HomePageFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, defaultFragment)
                .commit();

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String fragmentTitle = navigationOptions[position];
                selectItem(fragmentTitle);
            }
        });
    }

    private void selectItem(String title) {
        Fragment fragment;
        setTitle(title);
        switch(title) {
            case "Homepage":
                fragment = new HomePageFragment();
                break;

            case "What to do":
                fragment = new TodoFragment();
                break;
            case "Food & Drinks":
                fragment = new FoodFragment();
                break;
            case "Charlotte Neighborhoods":
                fragment = new NeighborhoodsFragment();
                break;

            case "History/Historical Places":
               fragment = new HistoryFragment();
                break;
           case "Public Transportation":
               fragment = new TransportationFragment();
               break;
            case "Surrounding Area":
                fragment = new AreaFragment();
                break;
            case "Sports":
                fragment = new SportsFragment();
                break;
//            case "Other Sources":
//                break;
 //           case "Happening This Week":
 //           break;
            default:
                fragment = new DemoFragment();
                break;
        }



        // Create a new fragment and specify the planet to show based on position
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        // Highlight the selected item, update the title, and close the drawer
//        mDrawerList.setItemChecked(position, true);
//        setTitle(navigationOptions[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

}