package com.qalbit.daggerdemo.ui;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigator provideScreenNavigtor(DefaultScreenNavigator screenNavigator);
}
