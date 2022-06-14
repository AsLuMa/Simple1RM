package com.example.a1rmsimple;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    TextView calculation;
    TextView percent;
    EditText one_rm;

    //TODO should this be the gridview? "Data to display"
    private final LinkedList<String> mWeightList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private RecycleViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculation = findViewById(R.id.rep_weight);
        one_rm = findViewById(R.id.enter_max);
        percent = findViewById(R.id.rep_percent);

        for (int i = 0; i < 10; i++){
            mWeightList.addLast("1" + i);
        }

        mRecyclerView = findViewById(R.id.recyclerWeight);
        mAdapter = new RecycleViewAdapter(this, mWeightList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

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
- må lage xml-fil til gridview
- recycleview? read tutorial for how to implement

Logikk:
- separate the math from the good stuff
- vil at matten skal oppdatere seg etterkvart som eg taster inn og sletter tal (no oppdaterer den seg på done)




*/
