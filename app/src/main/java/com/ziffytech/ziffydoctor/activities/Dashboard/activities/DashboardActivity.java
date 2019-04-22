package com.ziffytech.ziffydoctor.activities.Dashboard.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ziffytech.ziffydoctor.R;
import com.ziffytech.ziffydoctor.activities.Dashboard.adapters.AdapterDrawer;
import com.ziffytech.ziffydoctor.activities.Dashboard.adapters.AllMenuAdapter;
import com.ziffytech.ziffydoctor.activities.Dashboard.models.AllMenuModel;
import com.ziffytech.ziffydoctor.activities.DrawerMenu.activities.AccountsActivity;
import com.ziffytech.ziffydoctor.activities.DrawerMenu.activities.ClinicsActivity;
import com.ziffytech.ziffydoctor.activities.DrawerMenu.activities.DoctorInfoActivity;
import com.ziffytech.ziffydoctor.activities.DrawerMenu.activities.Doctor_schedule;
import com.ziffytech.ziffydoctor.activities.DrawerMenu.activities.Notification;
import com.ziffytech.ziffydoctor.activities.DrawerMenu.activities.Referus;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    TextView text_app_number;
    TextView text_completed_numbers;
    TextView text_cancel_numbers;
    TextView text_clinic_name;
    ImageView img_doc_profile;
    RecyclerView recycler_view_all_menu;
    DrawerLayout drawer_layout;
    AdapterDrawer adapterDrawer;
    ListView listView_left_drawer;
    ImageView imgv_drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();

        ArrayList<Integer> itemsimg = new ArrayList<Integer>();
        itemsimg.add(R.drawable.ic_app_01);
        itemsimg.add(R.drawable.ic_test_02);
        itemsimg.add(R.drawable.ic_patient_03);
        itemsimg.add(R.drawable.ic_consult_04);
        itemsimg.add(R.drawable.ic_emerency_05);
        itemsimg.add(R.drawable.ic_news_06);
        itemsimg.add(R.drawable.ic_near_me_07);

        AllMenuModel model=new AllMenuModel();

        AllMenuAdapter allMenuAdapter=new AllMenuAdapter(DashboardActivity.this,itemsimg);
        GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recycler_view_all_menu.setLayoutManager(manager);
        recycler_view_all_menu.setAdapter(allMenuAdapter);

    }

    private void setUpViews()
    {

        getSupportActionBar().hide();
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        adapterDrawer = new AdapterDrawer(DashboardActivity.this, getResources().getStringArray(R.array.menus));
        listView_left_drawer = (ListView) findViewById(R.id.left_drawer);
        listView_left_drawer.setOnItemClickListener(this);
        listView_left_drawer.setAdapter(adapterDrawer);
        imgv_drawer = (ImageView)findViewById(R.id.imgv_drawer);
        imgv_drawer.setOnClickListener(this);

        text_app_number=findViewById(R.id.text_app_numbers);
        text_completed_numbers=findViewById(R.id.text_completed);
        text_cancel_numbers=findViewById(R.id.text_cancel);
        text_clinic_name=findViewById(R.id.text_clinic_name);
        img_doc_profile=findViewById(R.id.img_doct_profile);
        recycler_view_all_menu=findViewById(R.id.recycler_view_all_menu);
    }



    public void onClick(View view)
    {
        if (view.getId()== R.id.imgv_drawer)
        {
            if (drawer_layout.isDrawerOpen(Gravity.LEFT))
            {
                drawer_layout.closeDrawer(Gravity.LEFT);
            }
            else
            {
                drawer_layout.openDrawer(Gravity.LEFT);
            }
        }

    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {

        if(i==1)
        {
            Intent profile = new Intent(DashboardActivity.this, DoctorInfoActivity.class);
            startActivity(profile);
        }
        if(i==2)
        {
            Intent profile = new Intent(DashboardActivity.this, ClinicsActivity.class);
            startActivity(profile);
        }
        if(i==3)
        {
            Intent profile = new Intent(DashboardActivity.this, Doctor_schedule.class);
            startActivity(profile);
        }
        if(i==4)
        {
        }
        if(i==5)
        {
            Intent profile = new Intent(DashboardActivity.this, AccountsActivity.class);
            startActivity(profile);
        }
        if(i==6)
        {
        }
        if(i==7)
        {
            Intent profile = new Intent(DashboardActivity.this, Notification.class);
            startActivity(profile);
        }
        if(i==8)
        {
        }
        if(i==9)
        {
            Intent profile = new Intent(DashboardActivity.this, Referus.class);
            startActivity(profile);
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) { }
}
