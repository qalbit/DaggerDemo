package com.qalbit.daggerdemo.details;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.qalbit.daggerdemo.model.Contributor;

import java.util.List;

@AutoValue
public abstract class ContributorState {
    abstract boolean loading();

    @Nullable
    abstract List<Contributor> contributors();

    @Nullable
    abstract Integer errorRes();

    boolean isSuccess() {
        return errorRes() == null;
    }

    static Builder builder() {
        return new AutoValue_ContributorState.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {

        abstract Builder loading(boolean loading);

        abstract Builder contributors(List<Contributor> contributors);

        abstract Builder errorRes(Integer errorRes);

        abstract ContributorState build();
    }
}
