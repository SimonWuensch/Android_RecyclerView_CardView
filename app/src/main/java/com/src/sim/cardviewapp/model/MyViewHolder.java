package com.src.sim.cardviewapp.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.src.sim.cardviewapp.R;
import com.src.sim.cardviewapp.data.Person;

public class MyViewHolder extends RecyclerView.ViewHolder {

    //Diese Textviews wurden in der cardview.xml definiert
    private final TextView id, forename, surname, add;

    //override default ViewHolder constructor
    public MyViewHolder(View itemView) {
        super(itemView);

        //initialisiere UI Elemente mit itemView
        id = ((TextView)itemView.findViewById(R.id.CardView_tvID));
        forename = ((TextView)itemView.findViewById(R.id.CardView_tvFirstName));
        surname = ((TextView)itemView.findViewById(R.id.CardView_tvLastName));
        add = ((TextView)itemView.findViewById(R.id.CardView_tvADD));
    }

    //UI-Elemente werden befüllt
    public void assignData(Person data){
            id.setText("" + data.id);
            forename.setText(data.firstName);
            surname.setText(data.lastName);
    }
}
