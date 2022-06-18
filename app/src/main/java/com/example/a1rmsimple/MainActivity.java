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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //TODO should this be the gridview? "Data to display"
    //TODO Should these Strings be ints or will that just mess everything up?
    private final LinkedList<String> mCalculation = new LinkedList<>();
    private final LinkedList<Integer> mPercentList = new LinkedList<>();
    private final HashMap<Integer, Integer> percentCalculation = new HashMap<>();

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

        /*int startingPercentage = 70;
        for (int i = 0; i <= 9; i++){
            percentCalculation.put(startingPercentage,
                    doBasicMath(startingPercentage, Integer.parseInt(one_rm.getText().toString())));
            startingPercentage += 5;
        }

        for (HashMap.Entry<Integer, Integer> var : percentCalculation.entrySet()){
            System.out.println(var.getKey() + " " + var.getValue());
        }*/


        // TODO comment these loops out once you're done with the hashmap implementation
        int start = 70;
        for (int i = 0; i <= 9; i++) {
            mPercentList.add(start);
            start += 5;
        }

        System.out.println(mPercentList);

        for (int j = 0; j <= 8; j++){
            mCalculation.addLast("1" + j);
        }

        System.out.println(mCalculation);

        mRecyclerView = findViewById(R.id.recyclerWeight);
        mAdapter = new RecycleViewAdapter(this, mCalculation);
        mRecyclerView.setAdapter(mAdapter);
        // THE ORIGINAL mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    public int doBasicMath(int percentageOfMax, int maxWeight){
        System.out.println("Behold! We did basic math.");
        return (maxWeight * percentageOfMax)/100;
    }

    public void updateWeightEditText(View view){
        //TODO need to pass percentageOfMax from somewhere else
        int calculated = doBasicMath(70, Integer.parseInt(one_rm.getText().toString()));
        calculation.setText(String.valueOf(calculated));
        System.out.println("We showed basic math!");
    }

}

/* TODO

UI:
- padding/margins for grid to constraintlayout
- grid moves into enter_weight edittext when keyboard is opened

Logikk:
- separate the math from the good stuff
- data in each column should update as I input and delete data from max_weight edittext
- fix data - both percentage
- fix data - update edittext with result from calculation



*/
