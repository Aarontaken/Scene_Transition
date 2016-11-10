package com.aaron.me.scene_transition;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.transition.AutoTransition;
import android.transition.ChangeImageTransform;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class Demo1Activity extends AppCompatActivity {

    @InjectView(R.id.image)
    ImageView image;
    @InjectView(R.id.title)
    TextView title;
    @InjectView(R.id.subTitle)
    TextView subTitle;
    @InjectView(R.id.desc)
    TextView desc;
    @InjectView(R.id.transition)
    ImageView transitionBtn;
    @InjectView(R.id.root)
    LinearLayout root;
    @InjectView(R.id.desc_container)
    ScrollView descContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.transition)
    public void onClick() {
        TransitionSet transitionSet = getTransitionSet();
        TransitionManager.beginDelayedTransition(root, transitionSet);
        // 接下来root下的所有view只要发生变化便会执行transitionSet中动画
        if (desc.getVisibility() != View.VISIBLE) {
            desc.setVisibility(View.VISIBLE);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip2px(280));
            image.setLayoutParams(layoutParams);
            transitionBtn.setImageResource(R.drawable.ic_close_detail);
        }else {
            desc.setVisibility(View.GONE);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
            image.setLayoutParams(layoutParams);
            transitionBtn.setImageResource(R.drawable.ic_see_detail);
        }
    }

    @NonNull
    private TransitionSet getTransitionSet() {
        Slide slide = new Slide(Gravity.BOTTOM);
        AutoTransition autoTransition = new AutoTransition();
        ChangeImageTransform changeImageTransform = new ChangeImageTransform();
        changeImageTransform.setStartDelay(200);
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(slide)
            .addTransition(autoTransition)
            .addTransition(changeImageTransform);
        return transitionSet;

    }

    public int dip2px( float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale +0.5f);
    }
}
