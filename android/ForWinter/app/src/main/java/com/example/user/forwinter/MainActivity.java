package com.example.user.forwinter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

public class MainActivity extends AppCompatActivity {

    CarouselView customCarouselView;
    int NUMBER_OF_PAGES = 5;

    private Button[][] buttons = new Button[7][3];
    private int[][] btnid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCarouselView = (CarouselView) findViewById(R.id.customCarouselView);
        customCarouselView.setPageCount(NUMBER_OF_PAGES);
        // set ViewListener for custom view
        customCarouselView.setViewListener(viewListener);
    }

    ViewListener viewListener = new ViewListener() {

        @Override
        public View setViewForPosition(int position) {
            View customView = getLayoutInflater().inflate(R.layout.weekly, null);
            //set view attributes here

            return customView;
        }
    };

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