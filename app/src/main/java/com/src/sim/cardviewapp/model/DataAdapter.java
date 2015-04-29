package com.src.sim.cardviewapp.model;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.src.sim.cardviewapp.data.Person;

import java.util.List;

public class DataAdapter extends  RecyclerView.Adapter<MyViewHolder> {

    private final List<Person> personList;
    private int layout;

    //Übergabe von einer List<T>. Diese Liste wird als einzelne karten im RecyclerView angelegt
    //layout ist die Cardview
    public DataAdapter(List<Person> personList, int layout){
        this.personList = personList;
        this.layout = layout;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //Hier wird eine Karte erstellt. i ist die ite stelle in der list, die im construkter übergeben wurde.
        final View v = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);
        final int position = i;

        //hier kann ein clicklistener implementiert werden
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Click", "Clicked");
            }
        });

        return new MyViewHolder(v);
    }

    //standart Override methoden
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.assignData(personList.get(position));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }
}