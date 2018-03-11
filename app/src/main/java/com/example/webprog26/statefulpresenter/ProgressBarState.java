package com.example.webprog26.statefulpresenter;

/**
 * Created by webprog26 on 11.03.18.
 */

public class ProgressBarState implements Contract.State {

    final int postion;

    public ProgressBarState(int postion) {
        this.postion = postion;
    }

    @Override
    public int getLastProgressBarPosition() {
        return postion;
    }
}
