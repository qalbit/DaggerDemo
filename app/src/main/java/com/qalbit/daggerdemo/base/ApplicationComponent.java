package com.qalbit.daggerdemo.base;

import com.qalbit.daggerdemo.data.RepoServiceModule;
import com.qalbit.daggerdemo.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class,
})
public interface ApplicationComponent {

    void inject(MyApplication application);
}
