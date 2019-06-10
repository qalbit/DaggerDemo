package com.qalbit.daggerdemo.data;

import com.qalbit.daggerdemo.model.Repo;
import com.qalbit.daggerdemo.testutils.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Provider;

import io.reactivex.Single;
import io.reactivex.internal.operators.single.SingleJust;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class RepoRepositoryTest {

    @Mock
    Provider<RepoRequester> repoRequesterProvider;
    @Mock RepoRequester repoRequester;

    private RepoRepository repository;
    private TrendingReposResponse trendingReposResponse;
    private Repo rxJavaRepo;
    private Repo otherRepo;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(repoRequesterProvider.get()).thenReturn(repoRequester);

        trendingReposResponse = TestUtils.loadJson("mock/get_trending_repos.json", TrendingReposResponse.class);
        when(repoRequester.getTrendingRepos()).thenReturn(Single.just(trendingReposResponse.repos()));

        rxJavaRepo = trendingReposResponse.repos().get(0);
        otherRepo = trendingReposResponse.repos().get(1);
        repository = new RepoRepository(repoRequesterProvider);
    }

    @Test
    public void getTrendingRepos() {
        repository.getTrendingRepos().test().assertValue(trendingReposResponse.repos());

        List<Repo> modifiedList = new ArrayList<>(trendingReposResponse.repos());
        modifiedList.remove(0);
        when(repoRequester.getTrendingRepos()).thenReturn(Single.just(modifiedList));

        repository.getTrendingRepos().test().assertValue(trendingReposResponse.repos());
    }

    @Test
    public void getRepo() {
        repository.getTrendingRepos().subscribe();

        when(repoRequester.getRepo(anyString(), anyString())).thenReturn(Single.just(otherRepo));

        repository.getRepo("ReactiveX", "RxJava").test().assertValue(rxJavaRepo);

        repository.getRepo("NotInCache", "NotInCache").test().assertValue(otherRepo);
    }
}