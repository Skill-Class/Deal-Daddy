package com.example.dealdaddy.Activity;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dealdaddy.R;

import static com.example.dealdaddy.R.layout.activity_checkout;

public class CheckoutActivity extends AppCompatActivity {

    private ImageView BackBtn;
    private Button payBtn;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_checkout);

        BackBtn = findViewById(R.id.navicon);
       // listView = findViewById(R.id.listView);
        payBtn = findViewById(R.id.button2);

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this, OrderConfirmActivity.class);
                startActivity(intent);
            }
        });


        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(CheckoutActivity.this);
                dialog.setContentView(R.layout.payment_dialog);

                ImageView cancelImage = dialog.findViewById(R.id.imageViewCancel);
                listView = dialog.findViewById(R.id.listView);

                dialog.setCancelable(true);
                dialog.show();

                cancelImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                String[] items = {"Credit Card", "Debit Card", "BHIM UPI", "EMI Unavailable (Why?) ",
                        "Pay on Delivery (Cash/Card)","Paytm"};

               ArrayAdapter<String> adapter = new ArrayAdapter<String>(CheckoutActivity.this, android.R.layout.simple_expandable_list_item_1,items);
               listView.setAdapter(adapter);

               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       if(position<=5){

                           Toast.makeText(CheckoutActivity.this, "Your order has been placed. Thank you for shopping. ",
                                   Toast.LENGTH_SHORT).show();
                           dialog.dismiss();
                           showNotification("Order Placed Successfully.\n","Hi Sheetal Kumar,\n" +
                                   "\n" +
                                   "From all of us at DealDaddy, welcome to our family! Thank you so much for your purchase of And Then There Were None. It’s a classic platform, and we’re sure you’ll love it!\n" +
                                   "\n" +
                                   "We’re a small E-commerce group and we stand by all of our titles. That means if you don’t like the product, you can trade it for any other product in our store. Just send your reply to feedback@dealdaddy.com and we’ll get everything sorted out.\n" +
                                   "\n" +
                                   "Thank you again for choosing DealDaddy, we hope to hear from you again soon!\n" +
                                   "\n" +
                                   "- Team DealDaddy");

                       }
                   }
               });

            }
        });

    }
    void showNotification(String title, String content) {
        NotificationManager mNotificationManager =
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default",
                    "YOUR_CHANNEL_NAME",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("YOUR_NOTIFICATION_CHANNEL_DISCRIPTION");
            mNotificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(CheckoutActivity.this, "default")
                .setSmallIcon(R.mipmap.ic_launcher_round) // notification icon
                .setContentTitle(title) // title for notification
                .setContentText(content)// message for notification

                // .setColor(getResources().getColor(R.color.colorPrimaryDark))
                // .setSound(android.R.) // set alarm sound for notification
                .setDefaults(Notification.DEFAULT_SOUND)
                .setStyle(new NotificationCompat.BigTextStyle()) // full text of notification
                .setAutoCancel(true); // clear notification after click
        mNotificationManager.notify(0, mBuilder.build());

    }

}
