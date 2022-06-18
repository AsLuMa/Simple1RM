package com.example.a1rmsimple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.RecycleViewHolder>{

    private final LinkedList<String> mWeightList;
    private LayoutInflater mInflater;

    public RecycleViewAdapter(Context context, LinkedList<String> weightList){
        mInflater = LayoutInflater.from(context);
        this.mWeightList = weightList;
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder{
        public final TextView weightTextView;
        final RecycleViewAdapter mAdapter;

        public RecycleViewHolder(View myView, RecycleViewAdapter adapter){
            super(myView);
            weightTextView = myView.findViewById(R.id.rep_weight);
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
        String mCurrent = mWeightList.get(position);
        holder.weightTextView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWeightList.size();
    }
}
