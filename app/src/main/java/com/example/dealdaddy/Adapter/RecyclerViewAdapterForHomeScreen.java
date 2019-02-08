package com.example.dealdaddy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dealdaddy.Activity.DetailActivity;
import com.example.dealdaddy.Model.ItemsWithImage;
import com.example.dealdaddy.Model.ItemsWithImageArrayList;
import com.example.dealdaddy.R;

import java.util.List;



/*
      @author - Sheetal Kumar
      hello world
 */



public class RecyclerViewAdapterForHomeScreen extends RecyclerView.Adapter<RecyclerViewAdapterForHomeScreen.MyViewHolder> {

    private Context mContext;
    private List<ItemsWithImageArrayList> mData;



    public RecyclerViewAdapterForHomeScreen(Context mContext, List<ItemsWithImageArrayList> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.custom_layout_homescreen, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        holder.modelImage.setImageResource(mData.get(position).getProductImage());
        holder.companyName.setText(mData.get(position).getCompanyName());

        holder.modelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                mContext.startActivity(intent);
            }
        });

        holder.modelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("ModelType",mData.get(position).getCompanyName());
                bundle.putInt("ModelImage",mData.get(position).getProductImage());
                intent.putExtras(bundle);
                mContext.startActivity(intent);

            }
        });
        /* holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,Book_Activity.class);

                // passing data to the book activity
                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                // start the activity
                mContext.startActivity(intent);

            }
        });*/


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView priceText,companyName;
        ImageView favImageView,modelImage;

        // CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

           // priceText = (TextView) itemView.findViewById(R.id.textView9);
            //favImageView = itemView.findViewById(R.id.imageView10);
            modelImage = itemView.findViewById(R.id.imageView9);
            companyName = itemView.findViewById(R.id.textView7);

            // String text = "\\u20B9 1245  \\u20B9 2490 (50% Off)";

            // SpannableString ss = new SpannableString(text);
            // SpannableStringBuilder ssb = new SpannableStringBuilder(text);

//            ForegroundColorSpan fcsRed = new ForegroundColorSpan(Color.RED);
            //          ssb.setSpan(fcsRed, 6, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            //        priceText.setText(ssb);

            //   img_book_thumbnail = (ImageView) itemView.findViewById(R.id.book_img_id);
            //   cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }
}
