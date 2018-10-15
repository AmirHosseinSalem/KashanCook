package com.example.amir.kshancook;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.amir.kshancook.adapters.BannerAdapter;
import com.example.amir.kshancook.adapters.CategoriesAdapter;
import com.example.amir.kshancook.adapters.RecipesAdapter;
import com.example.amir.kshancook.data.Banners;
import com.example.amir.kshancook.data.Categories;
import com.example.amir.kshancook.data.Recipes;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ApiService apiService;
    private Toolbar toolbar;

    private ProgressBar progressBarBanner;
    private ProgressBar progressBarCategory;
    private ProgressBar progressBarRecipes;

    private RecyclerView bannerRv;
    private RecyclerView categoryRv;
    private RecyclerView recipesRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = new ApiService(this);
        toolbar=findViewById(R.id.toolBar_main);

        progressBarBanner=findViewById(R.id.prograssBar_banner);
        progressBarCategory=findViewById(R.id.prograssBar_category);
        progressBarRecipes=findViewById(R.id.prograssBar_recipes);


        setupViews();
        setSupportActionBar(toolbar);
    }

    private void setupViews() {

        progressBarBanner.setVisibility(View.VISIBLE);
        progressBarCategory.setVisibility(View.VISIBLE);
        progressBarRecipes.setVisibility(View.VISIBLE);

        getBanners();
        getCategories();
        getRecipes();

    }


    private void getBanners() {

        apiService.getBanners(new Response.Listener<List<Banners>>() {
            @Override
            public void onResponse(List<Banners> response) {

                bannerRv = findViewById(R.id.rv_main_slider);

                bannerRv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));

                bannerRv.setAdapter(new BannerAdapter(response));

                SnapHelper snapHelper = new PagerSnapHelper();
                snapHelper.attachToRecyclerView(bannerRv);


                progressBarBanner.setVisibility(View.GONE);
                bannerRv.setVisibility(View.VISIBLE);
            }
        });



    }

    private void getCategories() {
        apiService.getCategories(new Response.Listener<List<Categories>>() {
            @Override
            public void onResponse(List<Categories> response) {
                categoryRv=findViewById(R.id.rv_main_categories);
                categoryRv.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));

                categoryRv.setAdapter(new CategoriesAdapter(response));

                progressBarCategory.setVisibility(View.GONE);
                categoryRv.setVisibility(View.VISIBLE);
            }
        });



    }

    private void getRecipes() {
        apiService.getRecipes(new Response.Listener<List<Recipes>>() {
            @Override
            public void onResponse(List<Recipes> response) {

                recipesRv=findViewById(R.id.rv_main_recipes);
                recipesRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                recipesRv.setAdapter(new RecipesAdapter(response));

                progressBarRecipes.setVisibility(View.GONE);
                recipesRv.setVisibility(View.VISIBLE);
            }
        });


    }
}
