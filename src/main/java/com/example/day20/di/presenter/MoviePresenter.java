package com.example.day20.di.presenter;

import com.example.day20.base.BasePresenter;
import com.example.day20.data.MovieBean;
import com.example.day20.di.contract.IMovieContract;
import com.example.day20.di.model.MovieModel;

/**
 * 作者：恆亙
 * 时间：2019/9/24
 * 功能：电影的 Presenter 层
 **/
public class MoviePresenter extends BasePresenter {

    private final MovieModel model;

    public MoviePresenter() {
        model = new MovieModel();
    }

    public void requestMovieInfo() {
        model.containMovieData(new IMovieContract.IMovieModel.IMovieCallBack() {
            @Override
            public void getMovieData(MovieBean movieBean) {
                getView().showMovieData(movieBean);
            }
        });
    }
}
