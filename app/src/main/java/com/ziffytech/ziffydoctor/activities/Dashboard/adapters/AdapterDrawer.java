package com.ziffytech.ziffydoctor.activities.Dashboard.adapters;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ziffytech.ziffydoctor.R;

public class AdapterDrawer extends ArrayAdapter<String> implements View.OnClickListener
{
    private final Activity context;
    String[] menus;

    public AdapterDrawer(Activity context, String[] menus)
    {
        super(context, R.layout.list_menu_items,menus);
        this.context = context;
        this.menus = menus;
    }

    public View getView(final int position, View view, ViewGroup parent)
    {
        if(position==0)
        {

             LayoutInflater inflator = context.getLayoutInflater();
             View rowView = inflator.inflate(R.layout.list_social_items, null,true);
             return rowView;

        }
        else
        {
            LayoutInflater inflator = context.getLayoutInflater();
            View rowView = inflator.inflate(R.layout.list_menu_items, null,true);
            TextView txtv_menu;
            ImageView imgv_icon;

            imgv_icon = (ImageView)rowView.findViewById(R.id.imgv_icon);
            txtv_menu = (TextView)rowView.findViewById(R.id.txtv_menu);
            txtv_menu.setText(""+menus[position]);
            TypedArray images = context.getResources().obtainTypedArray(R.array.images);
            images.getResourceId(position, -1);
            imgv_icon.setImageResource(images.getResourceId(position, -1));
            images.recycle();

            return rowView;

        }
    }

    @Override
    public void onClick(View v)
    {

    }
}