package com.src.sim.cardviewapp.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.src.sim.cardviewapp.R;
import com.src.sim.cardviewapp.data.Person;
import com.src.sim.cardviewapp.model.DataAdapter;

public class CardViewFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_card_view, container, false);

        //Recyclerview Verbindung über id
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.First_rcRecylcerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        //Recycler mit Adapter verbinden
        //Übergib eine List von Personen und das cardviewLayout
        RecyclerView.Adapter mAdapter = new DataAdapter(Person.createDefaultPersons(), R.layout.cardview_first);
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
