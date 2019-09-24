package com.example.day20.di.model;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.day20.data.Constant;
import com.example.day20.data.MovieBean;
import com.example.day20.di.contract.IMovieContract;
import com.example.day20.ui.App;
import com.google.gson.Gson;

/**
 * 作者：恆亙
 * 时间：2019/9/24
 * 功能：电影的 Model 层
 **/
public class MovieModel implements IMovieContract.IMovieModel {
    @Override
    public void containMovieData(final IMovieCallBack movieCallBack) {
        // 请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(App.context);
        // 请求字符串
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constant.MOVIE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                MovieBean movieBean = gson.fromJson(response, MovieBean.class);
                movieCallBack.getMovieData(movieBean);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                movieCallBack.getMovieData(null);
            }
        });
        requestQueue.add(stringRequest);
    }
}
