package com.example.dealdaddy.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dealdaddy.Activity.AboutItemActivity;
import com.example.dealdaddy.Activity.UpcomingProductsDetailsAcitivity;
import com.example.dealdaddy.Model.ItemsWithImage;
import com.example.dealdaddy.R;

import java.util.List;



/*
      @author - Sheetal Kumar
 */


public class RecyclerViewAdapterForUpcomingProducts extends RecyclerView.Adapter<RecyclerViewAdapterForUpcomingProducts.MyViewHolder> {

    private Context mContext;
    private List<ItemsWithImage> mData;


    public RecyclerViewAdapterForUpcomingProducts(Context mContext, List<ItemsWithImage> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.upcoming_product_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.productImage.setImageResource(mData.get(position).getProductImage());

        holder.productImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, UpcomingProductsDetailsAcitivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        (Activity) mContext, holder.productImage, ViewCompat.getTransitionName(holder.productImage));
                mContext.startActivity(intent, options.toBundle());
            }
        });

        holder.productName.setText(mData.get(position).getCompanyName());  // productname = company name
        holder.produtTime.setText(mData.get(position).getPrize());  // prize = time
        holder.itemDetailsText.setText(mData.get(position).getItemType());  //itemtype = product details


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemDetailsText,productName,produtTime;
        ImageView productImage;

        // CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            itemDetailsText = (TextView) itemView.findViewById(R.id.productDetails);
            productName = itemView.findViewById(R.id.productname);
            produtTime = itemView.findViewById(R.id.productDate);
            productImage = itemView.findViewById(R.id.productImage);
        }
    }
}
