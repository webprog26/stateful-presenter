package com.example.webprog26.statefulpresenter;

import android.app.Application;
import android.preference.PreferenceManager;

/**
 * Created by webprog26 on 11.03.18.
 */

public class App extends Application {

    private static Repository repositoryInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        repositoryInstance = new Repository(PreferenceManager.getDefaultSharedPreferences(this));
    }

    public static Repository getRepositoryInstance() {
        return repositoryInstance;
    }
}
