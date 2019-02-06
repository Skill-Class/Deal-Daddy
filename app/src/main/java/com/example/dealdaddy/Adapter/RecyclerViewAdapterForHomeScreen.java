package com.example.dealdaddy.Adapter;

import android.app.Activity;
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

      /*  holder.modelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                mContext.startActivity(intent);
            }
        });*/

        holder.modelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("ModelType", mData.get(position).getCompanyName());
                bundle.putInt("ModelImage", mData.get(position).getProductImage());
                intent.putExtras(bundle);
               // mContext.(R.anim.slide_in_right,R.anim.slide_out_right);
               // startActivity(intent_next);
               // finish();
                Activity activity = (Activity) mContext;
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.zoom_exit,R.anim.slide_out_right);

            }
        });


        if (position == 0) {

            holder.modelFirstImage.setImageResource(mData.get(position).getItemForHomeImages().get(0).getMenImage());
            holder.modelSecondImage.setImageResource(mData.get(position).getItemForHomeImages().get(1).getMenImage());
            holder.modelThirdImage.setImageResource(mData.get(position).getItemForHomeImages().get(2).getMenImage());
            holder.modelFourthImage.setImageResource(mData.get(position).getItemForHomeImages().get(3).getMenImage());

        }if(position ==1){
            holder.modelFirstImage.setImageResource(mData.get(position).getItemForHomeImages().get(0).getWomenImage());
            holder.modelSecondImage.setImageResource(mData.get(position).getItemForHomeImages().get(1).getWomenImage());
            holder.modelThirdImage.setImageResource(mData.get(position).getItemForHomeImages().get(2).getWomenImage());
            holder.modelFourthImage.setImageResource(mData.get(position).getItemForHomeImages().get(3).getWomenImage());

        }
        if(position ==2){
            holder.modelFirstImage.setImageResource(mData.get(position).getItemForHomeImages().get(0).getKidsImage());
            holder.modelSecondImage.setImageResource(mData.get(position).getItemForHomeImages().get(1).getKidsImage());
            holder.modelThirdImage.setImageResource(mData.get(position).getItemForHomeImages().get(2).getKidsImage());
            holder.modelFourthImage.setImageResource(mData.get(position).getItemForHomeImages().get(3).getKidsImage());

        }
        if(position ==3){
            holder.modelFirstImage.setImageResource(mData.get(position).getItemForHomeImages().get(0).getFurnitureImage());
            holder.modelSecondImage.setImageResource(mData.get(position).getItemForHomeImages().get(1).getFurnitureImage());
            holder.modelThirdImage.setImageResource(mData.get(position).getItemForHomeImages().get(2).getFurnitureImage());
            holder.modelFourthImage.setImageResource(mData.get(position).getItemForHomeImages().get(3).getFurnitureImage());

        }


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

        TextView priceText, companyName;
        ImageView favImageView, modelImage;

        ImageView modelFirstImage, modelSecondImage, modelThirdImage, modelFourthImage;


        // CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            // priceText = (TextView) itemView.findViewById(R.id.textView9);
            //favImageView = itemView.findViewById(R.id.imageView10);
            modelImage = itemView.findViewById(R.id.imageView9);
            companyName = itemView.findViewById(R.id.textView7);
            modelFirstImage = itemView.findViewById(R.id.imageView91);
            modelSecondImage = itemView.findViewById(R.id.imageView911);
            modelThirdImage = itemView.findViewById(R.id.imageView9111);
            modelFourthImage = itemView.findViewById(R.id.imageView91111);

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
