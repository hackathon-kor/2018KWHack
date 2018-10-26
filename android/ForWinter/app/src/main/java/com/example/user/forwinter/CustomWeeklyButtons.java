package com.example.user.forwinter;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomWeeklyButtons extends LinearLayout {

    LinearLayout ly;
    ImageButton[] btns = new ImageButton[7];

    public CustomWeeklyButtons(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initView();
        getAttrs(attrs);
    }

    public CustomWeeklyButtons(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();
        getAttrs(attrs);
    }

    private void initView() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        View v = li.inflate(R.layout.weekly, this, false);
        addView(v);

        btns[0] = (ImageButton) findViewById(R.id.btn0);
        btns[1] = (ImageButton) findViewById(R.id.btn1);
        btns[2] = (ImageButton) findViewById(R.id.btn2);
        btns[3] = (ImageButton) findViewById(R.id.btn3);
        btns[4] = (ImageButton) findViewById(R.id.btn4);
        btns[5] = (ImageButton) findViewById(R.id.btn5);
        btns[6] = (ImageButton) findViewById(R.id.btn6);
    }

    private void getAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.WeeklyButtons);

        setTypeArray(typedArray);
    }

    private void getAttrs(AttributeSet attrs, int defStyle) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.WeeklyButtons, defStyle, 0);

        setTypeArray(typedArray);
    }

    private void setTypeArray(TypedArray typedArray) {
        int[] btnid = new int[7];
        int[] btn_resid = new int[7];

        btnid[0]=R.drawable.question_mark_button;
        btnid[1]=R.drawable.question_mark_button;
        btnid[2]=R.drawable.question_mark_button;
        btnid[3]=R.drawable.question_mark_button;
        btnid[4]=R.drawable.question_mark_button;
        btnid[5]=R.drawable.question_mark_button;
        btnid[6]=R.drawable.question_mark_button;

        // 데이터에 따라 int 변수 7개에 각각의 버튼에 들어갈 이미지 id 저장하고 그거로 넣기
        btn_resid[0] = typedArray.getResourceId(R.styleable.WeeklyButtons_btn0, btnid[0]);
        btn_resid[1] = typedArray.getResourceId(R.styleable.WeeklyButtons_btn0, btnid[1]);
        btn_resid[2] = typedArray.getResourceId(R.styleable.WeeklyButtons_btn0, btnid[2]);
        btn_resid[3] = typedArray.getResourceId(R.styleable.WeeklyButtons_btn0, btnid[3]);
        btn_resid[4] = typedArray.getResourceId(R.styleable.WeeklyButtons_btn0, btnid[4]);
        btn_resid[5] = typedArray.getResourceId(R.styleable.WeeklyButtons_btn0, btnid[5]);
        btn_resid[6] = typedArray.getResourceId(R.styleable.WeeklyButtons_btn0, btnid[6]);

        btns[0].setImageResource(btn_resid[0]);
        btns[1].setImageResource(btn_resid[1]);
        btns[2].setImageResource(btn_resid[2]);
        btns[3].setImageResource(btn_resid[3]);
        btns[4].setImageResource(btn_resid[4]);
        btns[5].setImageResource(btn_resid[5]);
        btns[6].setImageResource(btn_resid[6]);

        typedArray.recycle();
    }

    void setImg(int idx, int img_resID) {
        btns[idx].setImageResource(img_resID);
    }
}
