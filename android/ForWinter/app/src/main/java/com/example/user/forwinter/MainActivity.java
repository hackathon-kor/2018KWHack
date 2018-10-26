package com.example.user.forwinter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button[][] buttons = new Button[7][3];
    private int[][] btnid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons[0][0] = (Button) findViewById(R.id.btn0);
        buttons[0][1] = (Button) findViewById(R.id.btn1);
        buttons[0][2] = (Button) findViewById(R.id.btn2);
        buttons[0][3] = (Button) findViewById(R.id.btn3);
        buttons[0][4] = (Button) findViewById(R.id.btn4);
        buttons[0][5] = (Button) findViewById(R.id.btn5);
        buttons[0][6] = (Button) findViewById(R.id.btn6);
        buttons[0][7] = (Button) findViewById(R.id.btn7);
        buttons[0][8] = (Button) findViewById(R.id.btn8);
        buttons[0][9] = (Button) findViewById(R.id.btn9);
        buttons[1][0] = (Button) findViewById(R.id.btn10);
        buttons[1][1] = (Button) findViewById(R.id.btn11);
        buttons[1][2] = (Button) findViewById(R.id.btn12);
        buttons[1][3] = (Button) findViewById(R.id.btn13);
        buttons[1][4] = (Button) findViewById(R.id.btn14);
        buttons[1][5] = (Button) findViewById(R.id.btn15);
        buttons[1][6] = (Button) findViewById(R.id.btn16);
        buttons[1][7] = (Button) findViewById(R.id.btn17);
        buttons[1][8] = (Button) findViewById(R.id.btn18);
        buttons[1][9] = (Button) findViewById(R.id.btn19);
        buttons[2][0] = (Button) findViewById(R.id.btn20);
    }

    private View.OnClickListener btnListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 11; j++){
                    if(v.getId() == buttons[i][j].getId()) {
                        buttons[i][j].setText("ok");
                    }
                }
            }
        }
    };
}
