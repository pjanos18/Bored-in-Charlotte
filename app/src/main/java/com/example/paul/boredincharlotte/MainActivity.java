package com.example.paul.boredincharlotte;

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

    private String[] mPlanetTitles = {
            "Homepage",
            "What to do",
            "Food & Drinks",
            "Charlotte Neighborhoods",
            "History/Historical Places",
            "Public Transportation",
            "Surrounding Area",
            "Sports",
            "Other Sources"
    };
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mPlanetTitles));

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int position = (int) l;
                Toast toast = Toast.makeText(view.getContext(), mPlanetTitles[position], Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

}
