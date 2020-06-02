package com.example.chapter3.demo.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.chapter3.demo.R;
import com.airbnb.lottie.LottieAnimationView;
public class LottieActivity extends AppCompatActivity {
    private LottieAnimationView animationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);
        animationView = findViewById(R.id.animation_view);
        animationView.playAnimation();

    }
}
