package com.qalbit.daggerdemo.base;

import android.app.Application;

import com.qalbit.daggerdemo.BuildConfig;
import com.qalbit.daggerdemo.di.ActivityInjector;

import javax.inject.Inject;

import dagger.Provides;
import timber.log.Timber;

public class MyApplication extends Application {

    @Inject
    ActivityInjector activityInjector;

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        // DaggerApplicationComponent will generate once you build the project
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        component.inject(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
