package com.example.amir.kshancook.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.amir.kshancook.R;
import com.example.amir.kshancook.data.Categories;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {

    private List<Categories> categoriesList;

    public CategoriesAdapter (List<Categories> categoriesList){
        this.categoriesList=categoriesList;
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.iteme_category,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        holder.bindCategory(categoriesList.get(position));

    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView iconCategory;
        private TextView titleCategory;

        public CategoryViewHolder(View itemView) {
            super(itemView);

            iconCategory=itemView.findViewById(R.id.circleImageView_category_icon);
            titleCategory=itemView.findViewById(R.id.tv_category_titleCategory);

        }

        public void bindCategory(Categories categories){
            Picasso.get().load(categories.getImg()).into(iconCategory);
            titleCategory.setText(categories.getTitle().toString());
        }
    }
}
