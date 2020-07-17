package com.koy.lifebaclib.app.live;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

public interface ObserveError<T,E> {
    Observe<T,E> observeError(@NonNull LifecycleOwner owner, @NonNull Observer<? super E> observer);
}

