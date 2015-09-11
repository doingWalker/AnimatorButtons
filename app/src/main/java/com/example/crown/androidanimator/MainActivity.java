package com.example.crown.androidanimator;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener{

    private int[] res = {R.id.button5,R.id.button1,R.id.button2,R.id.button3,R.id.button4};
    private List<Button> buttonList = new ArrayList<Button>();
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < res.length; i++){
            Button button = (Button) findViewById(res[i]);
            button.setOnClickListener(this);
            buttonList.add(button);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button5:
                if(!flag){
                    startAnimation();
                }else {
                    endAnimation();
                }
                break;
            case R.id.button1:
                Toast.makeText(MainActivity.this, "button1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Toast.makeText(MainActivity.this, "button2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                Toast.makeText(MainActivity.this, "button3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:
                Toast.makeText(MainActivity.this, "button4", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void startAnimation() {
        flag = true;
        for (int i = 0 ; i < res.length; i++){
            ObjectAnimator animator = ObjectAnimator.ofFloat(buttonList.get(i), "translationY",0f,i*150f);
            animator.setDuration(i*500);
            animator.setInterpolator(new BounceInterpolator());
            animator.start();
        }
    }

    private void endAnimation() {
        flag = false;
        for (int i = 0 ; i < res.length; i++){
            ObjectAnimator animator = ObjectAnimator.ofFloat(buttonList.get(i), "translationY",i*150f,0f);
            animator.setDuration(i * 500);
            animator.start();
        }
    }
}
