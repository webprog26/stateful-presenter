package com.example.webprog26.statefulpresenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by webprog26 on 11.03.18.
 */

public interface BaseStatefulPresenter<V extends BaseView, S extends  BaseState> extends BasePresenter<V> {

    void subscribe(@NonNull V view, @Nullable S state);
    @NonNull S getState();
}
