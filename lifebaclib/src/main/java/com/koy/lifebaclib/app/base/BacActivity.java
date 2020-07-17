package com.koy.lifebaclib.app.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 基础Activity
 * Created by guojs on 2019/3/27.2
 */
public abstract class BacActivity extends AppCompatActivity implements IActivityView {
    /**
     * 等待对话框
     */
    protected ProgressDialog progressBar;
    /**
     * view 缓存Map
     */
    protected SparseArray<View> viewMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }


    public <T extends View> T $(@IdRes int id) {
        return getViewById(id);
    }

    /**
     * 通过view Id缓存获取View实例
     *
     * @param id view Id
     * @return View实例
     */
    @Override
    public <T extends View> T getViewById(@IdRes int id) {
        if (viewMap == null) viewMap = new SparseArray<>();
        View view = viewMap.get(id);
        if (view == null) {
            view = findViewById(id);
            viewMap.put(id, view);
        }
        return (T) view;
    }

    /**
     * 添加Presenter层，实现Presenter生命周期管理
     *
     * @param observer IActivityPresenter
     */
    protected void addPresenter(@NonNull IPresenter observer) {
        getLifecycle().addObserver(observer);
    }

    /**
     * 弹出等待对话框
     *
     * @param contents 等待提示语，默认 请稍候
     */
    @Override
    public void showProgress(String... contents) {
        if (progressBar == null) {
            progressBar = new ProgressDialog(this);
        }
        progressBar.setMessage(contents != null && contents.length > 0 ? contents[0] : "请稍候");
        progressBar.show();
    }

    /**
     * 关闭等待对话框
     */
    @Override
    public void dismissProgress() {
        if (progressBar == null) return;
        progressBar.dismiss();
    }

    /**
     * 获取Activity实例
     *
     * @return Activity实例
     */
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }


}
