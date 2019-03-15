package com.reynaldiwijaya.learnanimationonandroid;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Value Animator
//        ValueAnimator animator = ValueAnimator.ofFloat(0f, 100f);
//        animator.setDuration(1000);
//        animator.start();
//
//        // Object Animator
//        ObjectAnimator animation = ObjectAnimator.ofFloat(textView, "translationX", 100f);
//        animation.setDuration(1000);
//        animation.start();

          // Transitions Jenis ChangeBounds
//        ChangeBounds changeBounds = new ChangeBounds();
//        changeBounds.setInterpolator(new AnticipateOvershootInterpolator());
//        changeBounds.setDuration(2000);

        //Transitions Set
//        TransitionSet transition = new TransitionSet();
//        transition.setOrdering(TransitionSet.ORDERING_SEQUENTIAL);

        final ViewGroup transitionsContainer = findViewById(R.id.transitions_container);
        final ImageView imageView = findViewById(R.id.image);

//        final TextView text = findViewById(R.id.text);
//        final Button button = findViewById(R.id.button);
//
//            button.setOnClickListener(new View.OnClickListener() {
//
//            boolean visible;
//
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            @Override
//            public void onClick(View v) {
//                TransitionManager.beginDelayedTransition(transitionsContainer);
//                visible = !visible;
//                text.setVisibility(visible ? View.VISIBLE : View.GONE);
//            }
//        });


        // AutoTransition
//        Transition transition = new AutoTransition()
//                .setDuration(500)
//                .setStartDelay(300)
//                .setInterpolator(new AccelerateDecelerateInterpolator());
//        TransitionManager.beginDelayedTransition(transitionsContainer, transition);


        imageView.setOnClickListener(new View.OnClickListener() {
            boolean mExpanded;
            @Override
            public void onClick(View v) {
                mExpanded = !mExpanded;
                TransitionManager.beginDelayedTransition(transitionsContainer, new TransitionSet()
                .addTransition(new ChangeBounds())
                .addTransition(new ChangeImageTransform()));

                ViewGroup.LayoutParams params = imageView.getLayoutParams();
                params.height = mExpanded ? ViewGroup.LayoutParams.WRAP_CONTENT :
                        ViewGroup.LayoutParams.WRAP_CONTENT;
                imageView.setLayoutParams(params);

                imageView.setScaleType(mExpanded ? ImageView.ScaleType.CENTER_CROP :
                        ImageView.ScaleType.FIT_CENTER);
            }
        });

    }

    public void clockwise(View view) {
        ImageView imageView = findViewById(R.id.image);
        Animation clockwiseAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        imageView.startAnimation(clockwiseAnim);
    }

    public void zoom(View view) {
        ImageView imageView = findViewById(R.id.image);
        Animation zoomAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        imageView.startAnimation(zoomAnim);
    }

    public void fade(View view) {
        ImageView imageView = findViewById(R.id.image);
        Animation fadeAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        imageView.startAnimation(fadeAnim);
    }

    public void slide(View view) {
        TextView textView = findViewById(R.id.textSlide);
        Animation animationSlide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        textView.setAnimation(animationSlide);
    }

    public void blink(View view){
        ImageView image = findViewById(R.id.image);
        Animation blinkAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(blinkAnim);
    }

    public void move(View view){
        ImageView image = findViewById(R.id.image);
        Animation moveAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        image.startAnimation(moveAnim);
    }
}
