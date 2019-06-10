package com.qalbit.daggerdemo.base;

import android.app.Activity;

import com.qalbit.daggerdemo.di.ActivityKey;
import com.qalbit.daggerdemo.home.MainActivity;
import com.qalbit.daggerdemo.home.TestMainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        TestMainActivityComponent.class,
})
public abstract class TestActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjector(TestMainActivityComponent.Builder builder);
}