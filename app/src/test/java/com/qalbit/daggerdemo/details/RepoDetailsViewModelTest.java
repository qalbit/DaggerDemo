package com.qalbit.daggerdemo.details;

import com.qalbit.daggerdemo.R;
import com.qalbit.daggerdemo.model.Contributor;
import com.qalbit.daggerdemo.model.Repo;
import com.qalbit.daggerdemo.testutils.TestUtils;
import com.squareup.moshi.Types;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class RepoDetailsViewModelTest {

    private RepoDetailsViewModel viewModel;

    private Repo repo = TestUtils.loadJson("mock/get_repo.json", Repo.class);
    private List<Contributor> contributors =
            TestUtils.loadJson("mock/get_contributors.json",
                    Types.newParameterizedType(List.class, Contributor.class));

    @Before
    public void setUp() throws Exception {
        viewModel = new RepoDetailsViewModel();
    }

    @Test
    public void details() throws Exception {
        viewModel.processRepo().accept(repo);

        viewModel.details().test().assertValue(
                RepoDetailState.builder()
                    .loading(false)
                    .name("RxJava")
                    .description("RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.")
                    .createdDate("Jan 08, 2013")
                    .updatedDate("Oct 06, 2017")
                    .build()
        );
    }

    @Test
    public void detailsError() throws Exception {
        viewModel.detailsError().accept(new IOException());

        viewModel.details().test().assertValue(
            RepoDetailState.builder()
                .loading(false)
                .errorRes(R.string.api_error_single_repo)
                .build()
        );
    }

    @Test
    public void contributors() throws Exception {
        viewModel.processContributors().accept(contributors);

        viewModel.contributors().test().assertValue(
                ContributorState.builder()
                    .loading(false)
                    .contributors(contributors)
                    .build()
        );
    }

    @Test
    public void contributorError() throws Exception {
        viewModel.contributorError().accept(new IOException());

        viewModel.contributors().test().assertValue(
                ContributorState.builder()
                    .loading(false)
                    .errorRes(R.string.api_error_contributors)
                    .build()
        );
    }
}