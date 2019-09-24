package com.example.day20.ui.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.day20.R;
import com.example.day20.data.MovieBean;

import java.util.List;

/**
 * 作者：恆亙
 * 时间：2019/9/24
 * 功能：电影的适配器
 **/
public class MyAdapter extends BaseQuickAdapter<MovieBean.ResultBean, BaseViewHolder> {
    public MyAdapter(int layoutResId, @Nullable List<MovieBean.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MovieBean.ResultBean item) {
        // 图片
        ImageView image = helper.getView(R.id.img);
        Glide.with(mContext).load(item.getImageUrl()).into(image);

        // 名字
        helper.setText(R.id.name, "影片名：" + item.getName());

        // 上映时间
        helper.setText(R.id.showTime, "上映时间：" + item.getReleaseTimeShow());
    }
}
