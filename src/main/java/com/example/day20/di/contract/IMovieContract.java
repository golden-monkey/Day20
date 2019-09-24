package com.example.day20.di.contract;

import com.example.day20.data.MovieBean;

/**
 * 作者：恆亙
 * 时间：2019/9/24
 * 功能：电影的契约类
 **/
public interface IMovieContract {
    // V 层
    public interface IMovieView {
        public void showMovieData(MovieBean movieBean);
    }

    // P 层
    public interface IMoviePresenter<IMovieView> {
        // 绑定
        public void attachView(IMovieContract.IMovieView movieView);

        // 解绑
        public void detachView();
    }

    // M 层
    public interface IMovieModel {
        // 请求
        public void containMovieData(IMovieCallBack movieCallBack);

        // 接口回调
        public interface IMovieCallBack {
            public void getMovieData(MovieBean movieBean);
        }
    }
}