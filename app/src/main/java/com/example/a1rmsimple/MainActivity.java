package com.example.a1rmsimple;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView calculation;
    TextView percent;
    EditText one_rm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculation = findViewById(R.id.rep_weight);
        one_rm = findViewById(R.id.enter_max);
        percent = findViewById(R.id.rep_percent);
    }

    public void doBasicMath(View view){
        int input = Integer.parseInt(one_rm.getText().toString());
        String math = Integer.toString((input*70)/100);
        calculation.setText(math);
        System.out.println("We did basic math " + math);

    }

}

/* TODO

UI:
- sentrer edittext
- sentrer prosenten til boksen under når den utvider seg med tre tal

Logikk:
- separate the math from the good stuff
- vil at matten skal oppdatere seg etterkvart som eg taster inn og sletter tal (no oppdaterer den seg på done)




*/
