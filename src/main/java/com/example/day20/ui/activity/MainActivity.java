package com.example.day20.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.day20.R;
import com.example.day20.base.BaseActivity;
import com.example.day20.data.MovieBean;
import com.example.day20.di.contract.IMovieContract;
import com.example.day20.di.presenter.MoviePresenter;
import com.example.day20.ui.adapter.MyAdapter;

import java.util.ArrayList;

/**
 * @describe(描述)：MainActivity
 * @data（日期）: 2019/9/24
 * @time（时间）: 9:39
 * @author（作者）: 恆亙
 **/
public class MainActivity extends BaseActivity<IMovieContract.IMovieView, MoviePresenter> implements IMovieContract.IMovieView {

    private RecyclerView recyclerView;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    protected void initData() {
        mPresenter.requestMovieInfo();
    }

    @Override
    protected MoviePresenter createPresenter() {
        return new MoviePresenter();
    }

    @Override
    public void showMovieData(MovieBean movieBean) {
        if (movieBean != null) {
            // 添加布局管理器
            LinearLayoutManager manager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(manager);

            // 设置排列方式
            manager.setOrientation(LinearLayoutManager.VERTICAL);

            // 数据集合
            ArrayList<MovieBean.ResultBean> list = (ArrayList<MovieBean.ResultBean>) movieBean.getResult();

            // 设置适配器
            MyAdapter adapter = new MyAdapter(R.layout.item, list);
            recyclerView.setAdapter(adapter);
        }
    }
}
