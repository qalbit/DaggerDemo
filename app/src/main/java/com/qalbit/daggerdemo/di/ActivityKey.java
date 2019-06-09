package com.qalbit.daggerdemo.di;


import android.app.Activity;

import java.lang.annotation.Target;

import dagger.MapKey;
import dagger.internal.Beta;

import static java.lang.annotation.ElementType.METHOD;

/** {@link MapKey} annotation to key bindings by a type of an {@link Activity}. */
@Beta
@MapKey
@Target(METHOD)
public @interface ActivityKey {
    Class<? extends Activity> value();
}
