package com.example.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {

    ItemSelected activity;

    // this method will set communication within 2 fragments
    public interface ItemSelected
    {
        void onItemSelected(int index);
    }

    public ListFrag() {
        // Required empty public constructor
    }

    // this method is called when activity is called with fragment
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (ItemSelected) context;
    }

    // this method is called when activity on create method is returned
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String [] data = getResources().getStringArray(R.array.pieces);

        setListAdapter(new ArrayAdapter<String >(getActivity(), android.R.layout.simple_list_item_1, data));

        // if phone is in landscape mode
        if(this.getActivity().findViewById(R.id.layout_land) != null) {
            activity.onItemSelected(0);
        }
    }

    // this method tells about extactly which iteam in the list is clicked
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        activity.onItemSelected(position);

    }
}
