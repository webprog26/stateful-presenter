package com.example.webprog26.statefulpresenter;

import android.content.SharedPreferences;

/**
 * Created by webprog26 on 11.03.18.
 */

public class Repository {

    private final SharedPreferences sharedPreferences;

    private static final String KEY_LAST_POSITION = "last_position";

    public Repository(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public final void savePosition(final int position) {
        sharedPreferences.edit().putInt(KEY_LAST_POSITION, position).apply();
    }

    public final int getSavedPosition(){
        return sharedPreferences.getInt(KEY_LAST_POSITION, 0);
    }
}
