package com.yusriamir.counterapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    int limit = 0; // 0 = no limit , 33 , 100

    Button btnLimit100, btnLimit33, btnNoLimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//          Step 1 - create object
//          Step 2 - bind view using findViewById id function

        Button btnCount = findViewById(R.id.btnCount);
        TextView txtCount = findViewById(R.id.txtCount);

        btnLimit100 = findViewById(R.id.btnLimit100);
        btnLimit33 = findViewById(R.id.btnLimit33);
        btnNoLimit = findViewById(R.id.btnNoLimit);
        Button btnReset = findViewById(R.id.btnReset);

//          Step 3  - create setOnClickListener function
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Step 4 - custom code
//                count++;

                if(limit == 33 && count <33 ) {
                    count++;
                }
                else if (limit==100 && count <100){
                    count++;
                }
                else if (limit == 0){
                    count++;
                }
                txtCount.setText(""+count);

            }
        });



        btnLimit33.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limit =33;
                resetButtons();
                btnLimit33.setBackgroundColor(Color.GREEN);
            }

        }));

        btnLimit100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limit = 100;
                resetButtons();
                btnLimit100.setBackgroundColor(Color.GREEN);


            }
        });

        btnNoLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limit = 0;
                resetButtons();
                btnNoLimit.setBackgroundColor(Color.GREEN);

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                txtCount.setText("" + count);
            }
        });
    }
    private void resetButtons() {
        btnLimit33.setBackgroundColor(Color.LTGRAY);    // default color
        btnLimit100.setBackgroundColor(Color.LTGRAY);   // default color
        btnNoLimit.setBackgroundColor(Color.LTGRAY);    // default color
    }
}