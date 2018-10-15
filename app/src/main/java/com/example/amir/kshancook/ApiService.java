package com.example.amir.kshancook;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.amir.kshancook.data.Banners;
import com.example.amir.kshancook.data.Categories;
import com.example.amir.kshancook.data.Recipes;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class ApiService {
    private Context context;

    public ApiService(Context context) {
        this.context = context;
    }

    public void getRecipes(Response.Listener<List<Recipes>> recipeslistener) {
        GsonRequest<List<Recipes>> request = new GsonRequest<>(
                Request.Method.GET,
                "https://api.myjson.com/bins/n7bxs",
                new TypeToken<List<Recipes>>() {
                }.getType(),
                recipeslistener,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", "onErrorResponse: ");
                    }
                }

        );

        RequestQueueContainer.getRequestQueue(context).add(request);
    }

    public void getBanners(Response.Listener<List<Banners>> bannersListener) {
        GsonRequest<List<Banners>> request = new GsonRequest<>(
                Request.Method.GET,
                "https://api.myjson.com/bins/110sw0",
                new TypeToken<List<Banners>>() {
                }.getType(),
                bannersListener,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", "onErrorResponse: ");
                    }
                }

        );

        RequestQueueContainer.getRequestQueue(context).add(request);


    }

    public void getCategories(Response.Listener<List<Categories>> categoryListener) {

        GsonRequest<List<Categories>> request = new GsonRequest<>(
                Request.Method.GET,
                "https://api.myjson.com/bins/v0bog",
                new TypeToken<List<Categories>>() {
                }.getType(),
                categoryListener,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", "onErrorResponse: ");
                    }
                }

        );

        RequestQueueContainer.getRequestQueue(context).add(request);
    }
}
