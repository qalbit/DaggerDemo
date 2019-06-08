package com.qalbit.daggerdemo.home;

import com.bluelinelabs.conductor.Controller;
import com.qalbit.daggerdemo.R;
import com.qalbit.daggerdemo.base.BaseActivity;
import com.qalbit.daggerdemo.trending.TrendingReposController;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingReposController();
    }
}
