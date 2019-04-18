package com.ziffytech.ziffydoctor.activities.Dashboard.adapters;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ziffytech.ziffydoctor.R;
import com.ziffytech.ziffydoctor.activities.DrawerMenu.activities.AccountsActivity;
import com.ziffytech.ziffydoctor.activities.DrawerMenu.activities.ClinicsActivity;
import com.ziffytech.ziffydoctor.activities.OPD.activities.Activities.PatientlistTab;

import java.util.ArrayList;

public class AllMenuAdapter extends RecyclerView.Adapter<AllMenuAdapter.ProductHolder> {

    ArrayList<Integer> list;
    Activity activity;
    String type;
    private ArrayList<Integer> mFilteredList;

    public AllMenuAdapter(Activity activity, ArrayList<Integer> list)
    {
        this.list = list;
        this.activity = activity;
        mFilteredList = list;
        this.type = type;
    }

    @Override
    public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_menu, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductHolder holder, final int position)
    {
        holder.image_menu.setImageResource(list.get(position));
        if (position==0)
        {
            holder.text_menu_title.setText("Appointments");
            holder.card_menu.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    //holder.card_menu.set(Color.parseColor("#077d8b"));
                    //activity.startActivity(new Intent(activity, VitalSignsActivity.class));
                    activity.startActivity(new Intent(activity, PatientlistTab.class));
                }
            });

        }else if (position==1){
            holder.text_menu_title.setText("Test Basket");
        }else if(position==2){
            holder.text_menu_title.setText("My Patients");
        }else if(position==3){
            holder.text_menu_title.setText("Consult");
        }else if(position==4){
            holder.text_menu_title.setText("Emergency");

            holder.card_menu.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    activity.startActivity(new Intent(activity, AccountsActivity.class));

                }
            });
        }else if(position==5)
        {
            holder.text_menu_title.setText("News");
            holder.card_menu.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    activity.startActivity(new Intent(activity, ClinicsActivity.class));
                }
            });
        }else if(position==6){
            holder.text_menu_title.setText("Near Me");
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder
    {
        ImageView image_menu;
        TextView text_menu_title;
        CardView card_menu;
        public ProductHolder(View itemView)
        {
            super(itemView);
            image_menu=itemView.findViewById(R.id.image_menu);
            text_menu_title=itemView.findViewById(R.id.text_menu_title);
            card_menu=itemView.findViewById(R.id.card_menu);
        }
    }
}

