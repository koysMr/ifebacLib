package com.koy.lifebaclib.app.live;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

public interface Observe<T,E> {
    ObserveError<T,E> observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer);
}