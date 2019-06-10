package com.qalbit.daggerdemo.trending;

import android.annotation.SuppressLint;

import com.qalbit.daggerdemo.data.RepoRepository;
import com.qalbit.daggerdemo.di.ScreenScope;
import com.qalbit.daggerdemo.model.Repo;

import javax.inject.Inject;

@ScreenScope
class TrendingReposPresenter implements RepoAdapter.RepoClickedListener {

    private final TrendingReposViewModel viewModel;
    private final RepoRepository repoRepository;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRepository repoRepository) {
        this.viewModel = viewModel;
        this.repoRepository = repoRepository;
        loadRepos();
    }


    @SuppressLint("CheckResult")
    private void loadRepos() {
        repoRepository.getTrendingRepos()
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {
        //TODO Open Detail Page
    }
}
