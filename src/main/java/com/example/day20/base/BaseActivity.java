package com.example.day20.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.day20.di.contract.IMovieContract;

/**
 * 作者：恆亙
 * 时间：2019/9/24
 * 功能：Activity的抽基类
 **/
public abstract class BaseActivity<V, P extends BasePresenter> extends AppCompatActivity {

    public Context mContext;
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 绑定视图
        setContentView(bindLayout());
        // 上下文
        mContext = this;
        // 创建 P 层
        mPresenter = createPresenter();
        // 绑定 p 层
        mPresenter.attachView((IMovieContract.IMovieView) this);
        // 初始化控件
        initView();
        // 提供方法
        initData();
    }

    public abstract int bindLayout();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
