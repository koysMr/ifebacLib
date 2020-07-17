package com.koy.lifebaclib.app.base;

public interface IBacActivity {
    abstract class BacActivityPresenter<T extends IActivityView> implements IActivityPresenter {
        protected T mView;

        @Override
        public void onCreate(Object view) {
            if (view instanceof IActivityView) {
                mView = (T) view;
            }
            this.onCreate(mView);
        }

        public abstract void onCreate(T view);

        @Override
        public void onResume() {
            System.out.println("-->>onResume");
        }

        @Override
        public void onStart() {
            System.out.println("-->>onStart");
        }

        @Override
        public void onPause() {
            System.out.println("-->>onPause");
        }

        @Override
        public void onStop() {
            System.out.println("-->>onStop");
        }

        @Override
        public void onDestroy() {
            System.out.println("-->>onDestroy");
        }

    }
}
