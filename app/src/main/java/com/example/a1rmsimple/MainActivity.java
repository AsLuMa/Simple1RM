package com.example.a1rmsimple;

import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //TODO should this be the gridview? "Data to display"
    //TODO Should these Strings be ints or will that just mess everything up?
    private final List<String> mCalculation = new ArrayList<>();
    private final List<Integer> mPercentList = new ArrayList<>();
    //private final HashMap<Integer, Integer> percentCalculation = new HashMap<>();

    private RecyclerView mRecyclerView;
    private RecycleViewAdapter mAdapter;

    // the big textview
    private TextView calculation;
    // the small textview
    private TextView percent;
    private EditText one_rm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculation = findViewById(R.id.rep_weight);
        one_rm = findViewById(R.id.enter_max);
        percent = findViewById(R.id.rep_percent);

        int start = 70;
        for (int i = 0; i <= 8; i++) {
            mPercentList.add(start);
            start += 5;
        }

        System.out.println(mPercentList);

        for (int j = 0; j <= 8; j++){
            mCalculation.add("00");
        }

        System.out.println(mCalculation);

        mRecyclerView = findViewById(R.id.recyclerWeight);
        mAdapter = new RecycleViewAdapter(this, mCalculation, mPercentList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    public int doBasicMath(int percentageOfMax, int maxWeight){
        System.out.println("Behold! We did basic math.");
        return (maxWeight * percentageOfMax)/100;
    }

    public void updateWeightEditText(View view){
        if (!one_rm.getText().toString().equals("")){
            mCalculation.clear();
            int k = 0;
            for (int i = 0; i <= mPercentList.size()-1; i++){
                mCalculation.add(String.valueOf(doBasicMath(mPercentList.get(k), Integer.parseInt(one_rm.getText().toString()))));
                k++;
            }
            System.out.println("mcalc in update" + mCalculation);
            mAdapter.notifyDataSetChanged();
            //TODO update values/reinflate view - calculation.setText(String.valueOf(mCalculation));
            System.out.println("We showed basic math!");
        }

    }

}

/* TODO

UI:
- padding/margins for grid to constraintlayout
- fit calculated weight text into box - it doesn't look good when you end up with a three digit nr
- grid moves into enter_weight edittext when keyboard is opened

Logikk:
- separate the math from the good stuff
- data in each column should update as I input and delete data from max_weight edittext
- fix data - both percentage
- fix data - update edittext with result from calculation
- round up calculation



*/
