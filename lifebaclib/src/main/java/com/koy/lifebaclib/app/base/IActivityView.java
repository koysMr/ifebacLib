package com.koy.lifebaclib.app.base;

import android.app.Activity;
import android.view.View;

import androidx.lifecycle.LifecycleOwner;

/**
 * Activity View 基础接口
 */
public interface IActivityView extends IView, LifecycleOwner {
    /**
     * 弹出等待对话框
     *
     * @param contents 等待提示语，默认 请稍候
     */
    void showProgress(String... contents);

    /**
     * 关闭等待对话框
     */
    void dismissProgress();

    /**
     * 通过view Id缓存获取View实例
     *
     * @param id view Id
     * @return View实例
     */
    <T extends View> T getViewById(int id);

    /**
     * 获取Activity实例
     *
     * @return Activity实例
     */
     Activity getActivity();

    void toast(String msg);

}
