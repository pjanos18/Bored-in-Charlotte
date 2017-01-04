package com.example.paul.boredincharlotte;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Paul on 12/9/2016.
 */

public class EventFragment extends Fragment {
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState) {

       View view = inflater.inflate(R.layout.event_fragment, container, false);
        String name = getArguments().getString("name");
        String description = getArguments().getString("description");

        TextView nameTextview = (TextView) view.findViewById(R.id.event_name_textview);
        TextView descriptionTextView = (TextView) view.findViewById(R.id.event_description_textview);

        nameTextview.setText(name);
        descriptionTextView.setText(description);

        return view;
    }
}
