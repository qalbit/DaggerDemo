package com.qalbit.daggerdemo.home;

import com.bluelinelabs.conductor.Controller;
import com.qalbit.daggerdemo.di.ControllerKey;
import com.qalbit.daggerdemo.trending.TrendingReposComponent;
import com.qalbit.daggerdemo.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        TrendingReposComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);
}
