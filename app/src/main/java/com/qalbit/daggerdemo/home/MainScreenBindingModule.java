package com.qalbit.daggerdemo.home;

import com.bluelinelabs.conductor.Controller;
import com.qalbit.daggerdemo.details.RepoDetailsComponent;
import com.qalbit.daggerdemo.details.RepoDetailsController;
import com.qalbit.daggerdemo.di.ControllerKey;
import com.qalbit.daggerdemo.trending.TrendingReposComponent;
import com.qalbit.daggerdemo.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        TrendingReposComponent.class,
        RepoDetailsComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);

    @Binds
    @IntoMap
    @ControllerKey(RepoDetailsController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindRepoDetailsInjector(RepoDetailsComponent.Builder builder);
}
