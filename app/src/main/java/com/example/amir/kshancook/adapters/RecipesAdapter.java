package com.example.amir.kshancook.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.amir.kshancook.R;
import com.example.amir.kshancook.data.Recipes;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder> {

    private List<Recipes> recipesList;

    public RecipesAdapter (List<Recipes> recipesList){
        this.recipesList=recipesList;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecipeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipes,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.bindRecipe(recipesList.get(position));
    }

    @Override
    public int getItemCount() {
        return recipesList.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageRrcipr;
        private TextView titleRecipe;
        private TextView descriptionRecipe;
        private TextView authorRecipes;

        private RatingBar ratingRecipes;

        public RecipeViewHolder(View itemView) {
            super(itemView);

            imageRrcipr=itemView.findViewById(R.id.iv_itemRecipes_imageRecipes);
            titleRecipe=itemView.findViewById(R.id.iv_itemRecipes_titleRecipes);
            descriptionRecipe=itemView.findViewById(R.id.iv_itemRecipes_descriptionRecipes);
            authorRecipes=itemView.findViewById(R.id.iv_itemRecipes_authorRecipes);

            ratingRecipes=itemView.findViewById(R.id.ratingBar_itemRecipes_ratingBarRecipes);

        }

        public void bindRecipe (Recipes recipes){

            Picasso.get().load(recipes.getImg()).into(imageRrcipr);
            titleRecipe.setText(recipes.getTitle());
            descriptionRecipe.setText(recipes.getDesc());
            authorRecipes.setText("By : "+recipes.getBy());

            ratingRecipes.setRating(recipes.getRate());
        }
    }
}
