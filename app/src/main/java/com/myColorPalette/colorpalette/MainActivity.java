package com.myColorPalette.colorpalette;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Classes
    private final Animations animations = new Animations();
    private final Data data = new Data();
    private final Random random = new Random();
    private final Handler handler = new Handler();

    // Declare views
    LinearLayout linearLayoutVertical, linearLayoutHorizontal;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
    Button randomButton;

    // Declare variables
    int orientation;

    // Declare list
    List<List<Integer>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orientation = getResources().getConfiguration().orientation;

        // Initialize views
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        randomButton = findViewById(R.id.randomButton);
        linearLayoutVertical = findViewById(R.id.linearLayoutVertical);
        linearLayoutHorizontal = findViewById(R.id.linearLayoutHorizontal);

        // Initialize list
        list = data.paletteList;

        // Start parameters with orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            randomButton.setAlpha(0);
            randomButton.setEnabled(false);
            linearLayoutHorizontal.setAlpha(0);

            handler.postDelayed(() -> {

                imagesAnimationsOnCreate();
                randomButton.animate().alpha(0.50f).setDuration(300);
                linearLayoutHorizontal.setAlpha(1);
            }, 150);

            handler.postDelayed(() -> {

                randomButton.animate().alpha(1f).setDuration(300);
                randomButton.setEnabled(true);
            }, 1100);

        } else {

            randomButton.setAlpha(0);
            randomButton.setEnabled(false);
            linearLayoutVertical.setAlpha(0);

            handler.postDelayed(() -> {

                imagesAnimationsOnCreate();
                randomButton.animate().alpha(0.50f).setDuration(300);
                linearLayoutVertical.setAlpha(1);
            }, 150);

            handler.postDelayed(() -> {

                randomButton.animate().alpha(1f).setDuration(300);
                randomButton.setEnabled(true);
            }, 1100);
        }

        // Methods
        fullScreenCall();
        randomListMethod();
        randomButton();
    }

    // Hide all bars method
    private void fullScreenCall() {
        // Set fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
    }

    private void randomButton() {

        randomButton.setOnClickListener(v -> {

            randomButton.animate().alpha(0.50f).setDuration(300);
            randomButton.setEnabled(false);

            handler.postDelayed(() -> randomButton.animate().alpha(1f).setDuration(300), 1050);

            handler.postDelayed(() -> randomButton.setEnabled(true), 1350);

            randomListMethod();
            animationsMethod();
        });
    }

    private void randomListMethod() {

        // Randomize index
        int number = random.nextInt(17);

        // Set list items to ImageViews with delay by animations
        handler.postDelayed(() -> {

            imageView1.setBackgroundColor(getColor(list.get(number).get(0)));
            imageView4.setBackgroundColor(getColor(list.get(number).get(3)));
            imageView2.setBackgroundColor(getColor(list.get(number).get(1)));
            imageView3.setBackgroundColor(getColor(list.get(number).get(2)));
            imageView5.setBackgroundColor(getColor(list.get(number).get(4)));
        }, 600);
    }

    private void animationsMethod() {

        animations.animation(randomButton, 0, 300, 0, Techniques.Pulse);

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            imagesAnimationsLandscape();
        } else {

            imagesAnimationsPortrait();
        }
    }

    private void imagesAnimationsLandscape() {

        // 1st landscape animations
        animations.animation(imageView1, 0, 600, 0, Techniques.SlideOutDown);
        animations.animation(imageView2, 150, 600, 0, Techniques.SlideOutUp);
        animations.animation(imageView3, 0, 600, 0, Techniques.SlideOutDown);
        animations.animation(imageView4, 150, 600, 0, Techniques.SlideOutUp);
        animations.animation(imageView5, 0, 600, 0, Techniques.SlideOutDown);

        // 2nd landscape animations
        animations.animation(imageView1, 600, 600, 0, Techniques.SlideInDown);
        animations.animation(imageView2, 750, 600, 0, Techniques.SlideInUp);
        animations.animation(imageView3, 600, 600, 0, Techniques.SlideInDown);
        animations.animation(imageView4, 750, 600, 0, Techniques.SlideInUp);
        animations.animation(imageView5, 600, 600, 0, Techniques.SlideInDown);
    }

    private void imagesAnimationsPortrait() {

        // 1st portrait animations
        animations.animation(imageView1, 0, 600, 0, Techniques.SlideOutLeft);
        animations.animation(imageView2, 150, 600, 0, Techniques.SlideOutRight);
        animations.animation(imageView3, 0, 600, 0, Techniques.SlideOutLeft);
        animations.animation(imageView4, 150, 600, 0, Techniques.SlideOutRight);
        animations.animation(imageView5, 0, 600, 0, Techniques.SlideOutLeft);

        // 2nd portrait animations
        animations.animation(imageView1, 600, 600, 0, Techniques.SlideInRight);
        animations.animation(imageView2, 750, 600, 0, Techniques.SlideInLeft);
        animations.animation(imageView3, 600, 600, 0, Techniques.SlideInRight);
        animations.animation(imageView4, 750, 600, 0, Techniques.SlideInLeft);
        animations.animation(imageView5, 600, 600, 0, Techniques.SlideInRight);
    }

    private void imagesAnimationsOnCreate() {

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            animations.animation(randomButton, 0, 600, 0, Techniques.SlideInUp);

            animations.animation(imageView1, 0, 850, 0, Techniques.SlideInDown);
            animations.animation(imageView2, 150, 850, 0, Techniques.SlideInUp);
            animations.animation(imageView3, 0, 850, 0, Techniques.SlideInDown);
            animations.animation(imageView4, 150, 850, 0, Techniques.SlideInUp);
            animations.animation(imageView5, 0, 850, 0, Techniques.SlideInDown);
        } else {

            animations.animation(randomButton, 0, 600, 0, Techniques.SlideInUp);

            animations.animation(imageView1, 0, 850, 0, Techniques.SlideInRight);
            animations.animation(imageView2, 150, 850, 0, Techniques.SlideInLeft);
            animations.animation(imageView3, 0, 850, 0, Techniques.SlideInRight);
            animations.animation(imageView4, 150, 850, 0, Techniques.SlideInLeft);
            animations.animation(imageView5, 0, 850, 0, Techniques.SlideInRight);
        }
    }
}