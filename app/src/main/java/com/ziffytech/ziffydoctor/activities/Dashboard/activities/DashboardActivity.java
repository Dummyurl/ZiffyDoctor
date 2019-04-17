package com.ziffytech.ziffydoctor.activities.Dashboard.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ziffytech.ziffydoctor.R;
import com.ziffytech.ziffydoctor.activities.Dashboard.adapters.AllMenuAdapter;
import com.ziffytech.ziffydoctor.activities.Dashboard.models.AllMenuModel;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    TextView text_app_number;
    TextView text_completed_numbers;
    TextView text_cancel_numbers;
    TextView text_clinic_name;
    ImageView img_doc_profile;
    RecyclerView recycler_view_all_menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    private void setUpViews() {


        text_app_number=findViewById(R.id.text_app_numbers);
        text_completed_numbers=findViewById(R.id.text_completed);
        text_cancel_numbers=findViewById(R.id.text_cancel);
        text_clinic_name=findViewById(R.id.text_clinic_name);
        img_doc_profile=findViewById(R.id.img_doct_profile);
        recycler_view_all_menu=findViewById(R.id.recycler_view_all_menu);
    }
}
