package com.aaron.me.scene_transition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.demo1)
    CardView demo1;
    @InjectView(R.id.demo2)
    CardView demo2;
    @InjectView(R.id.demo3)
    CardView demo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.demo1, R.id.demo2, R.id.demo3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.demo1:
                startActivity(new Intent(this,Demo1Activity.class));
                break;
            case R.id.demo2:
                startActivity(new Intent(this,Demo2Activity.class));
                break;
            case R.id.demo3:
                break;
        }
    }
}
