package com.koy.lifebaclib.app.live;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class BacLiveData<T, E> implements ObserveError<T, E>, Observe<T, E> {

    MutableLiveData<T> mLiveData;
    MutableLiveData<E> mErrorData;

    public BacLiveData() {
        mLiveData = new MutableLiveData<>();
        mErrorData = new MutableLiveData<>();
    }

    public void postError(E value) {
        mErrorData.postValue(value);
    }


    public void postValue(T value) {
        mLiveData.postValue(value);
    }


    public void setValue(T value) {
        mLiveData.setValue(value);
    }


    public T getValue() {
        return mLiveData.getValue();
    }

    public boolean hasObservers() {
        return mLiveData.hasObservers();
    }

    public MutableLiveData<T> getLiveData() {
        return mLiveData;
    }


    public MutableLiveData<E> getErrorData() {
        return mErrorData;
    }

    @Override
    public ObserveError<T, E> observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
        mLiveData.observe(owner, observer);
        return this;
    }

    @Override
    public Observe<T, E> observeError(@NonNull LifecycleOwner owner, final @NonNull Observer<? super E> observer) {

        mErrorData.observe(owner,observer);
        return this;
    }


}
