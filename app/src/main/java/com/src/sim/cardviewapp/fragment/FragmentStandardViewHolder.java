package com.src.sim.cardviewapp.fragment;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.src.sim.cardviewapp.R;


public class FragmentStandardViewHolder extends RecyclerView.ViewHolder{

    private static String TAG = FragmentStandardViewHolder.class.getSimpleName();

    private Activity activity;
    private final TextView tvTextView;
    private View cardView;

    public FragmentStandardViewHolder(Activity activity, View cardView) {
        super(cardView);
        this.activity = activity;
        this.cardView = cardView;
        tvTextView = ((TextView) cardView.findViewById(R.id.fragment_standard_text_view));
    }

    protected void assignData(final String string){
        tvTextView.setText(string);

        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, string, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
