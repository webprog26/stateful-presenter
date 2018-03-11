package com.example.webprog26.statefulpresenter;

import android.support.annotation.NonNull;

/**
 * Created by webprog26 on 11.03.18.
 */

public interface BasePresenter<V extends BaseView> {

    void subscribe(@NonNull V view);
    void unsubscribe();
}
