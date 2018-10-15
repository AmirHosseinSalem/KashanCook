package com.example.amir.kshancook.adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.amir.kshancook.R;
import com.example.amir.kshancook.data.Banners;
import com.squareup.picasso.Picasso;

import java.util.List;


public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder>{


    private List<Banners> bannersList;

    public BannerAdapter(List<Banners> bannersList){
        this.bannersList=bannersList;

    }


    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new BannerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {

        holder.bindBanner(bannersList.get(position));

    }

    @Override
    public int getItemCount() {
        return bannersList.size();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder{

        private ImageView bannerImage;

        public BannerViewHolder(View itemView) {
            super(itemView);
            bannerImage= (ImageView) itemView ;
        }

        public void bindBanner(Banners banners){

            Picasso.get().load(banners.getImg()).into(bannerImage);
        }
    }
}
