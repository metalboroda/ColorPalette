package com.myColorPalette.colorpalette;

import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Animations {

    public void animation(View view, int delay, int duration, int repeat, Techniques techniques) {

        YoYo.with(techniques)
                .delay(delay)
                .duration(duration)
                .repeat(repeat)
                .playOn(view);
    }
}
