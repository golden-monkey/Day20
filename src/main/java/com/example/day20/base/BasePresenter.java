package com.example.day20.base;

import com.example.day20.di.contract.IMovieContract;

import java.lang.ref.WeakReference;

/**
 * 作者：恆亙
 * 时间：2019/9/24
 * 功能：Presenter的抽基类
 **/
public class BasePresenter<V extends IMovieContract.IMovieView> implements IMovieContract.IMoviePresenter<V> {

    private WeakReference<IMovieContract.IMovieView> weakReference;

    @Override
    public void attachView(IMovieContract.IMovieView movieView) {
        // 弱引用
        weakReference = new WeakReference<>(movieView);
    }

    // 获取数据
    public IMovieContract.IMovieView getView() {
        return weakReference.get();
    }

    @Override
    public void detachView() {
        weakReference.clear();
    }
}
