package com.example.a1rmsimple;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.RecycleViewHolder>{

    private final List<String> mWeightList;
    private final List<Integer> mPercentageList;
    private LayoutInflater mInflater;

    public RecycleViewAdapter(Context context, List<String> weightList, List<Integer> mPercentagelist){
        mInflater = LayoutInflater.from(context);
        this.mWeightList = weightList;
        this.mPercentageList = mPercentagelist;
        this.notifyDataSetChanged();
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder {
        public TextView weightTextView;
        public TextView percentageTextView;
        private RecycleViewAdapter mAdapter;

        public RecycleViewHolder(View myView, RecycleViewAdapter adapter){
            super(myView);
            weightTextView = myView.findViewById(R.id.rep_weight);
            percentageTextView = myView.findViewById(R.id.rep_percent);
            this.mAdapter = adapter;

        }


    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = mInflater.inflate(R.layout.grid_layout, parent, false);
        return new RecycleViewHolder(mView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {
        String wCurrent = mWeightList.get(position);
        int pCurrent = mPercentageList.get(position);
        //TODO this does nothing
        holder.weightTextView.setText(wCurrent);
        /*if (mWeightList.get(position).length() <= 2){
            holder.weightTextView.setTextSize(64);
        }
        else{
            holder.weightTextView.setTextSize(50);
        }*/
        //TODO fix this (the string resource already exists)
        holder.percentageTextView.setText(String.valueOf(pCurrent) + "%");
        holder.weightTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.weightTextView.getCurrentTextColor() != Color.RED){
                    holder.weightTextView.setTextColor(Color.RED);
                }
                else {
                    holder.weightTextView.setTextColor(Color.GRAY);
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return mWeightList.size();
    }
}
