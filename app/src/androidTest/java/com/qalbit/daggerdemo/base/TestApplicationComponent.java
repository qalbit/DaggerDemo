package com.qalbit.daggerdemo.base;

import com.qalbit.daggerdemo.data.TestRepoServiceModule;
import com.qalbit.daggerdemo.networking.ServiceModule;
import com.qalbit.daggerdemo.trending.TrendingReposControllerTest;
import com.qalbit.daggerdemo.ui.NavigationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        TestActivityBindingModule.class,
        TestRepoServiceModule.class,
        ServiceModule.class,
        NavigationModule.class,
})
public interface TestApplicationComponent extends ApplicationComponent {

    void inject(TrendingReposControllerTest trendingReposControllerTest);
}