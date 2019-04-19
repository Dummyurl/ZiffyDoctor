package com.ziffytech.ziffydoctor.activities.DrawerMenu.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.ziffytech.ziffydoctor.R;
import com.ziffytech.ziffydoctor.commanclass.CommonActivity;

public class ClinicsActivity extends CommonActivity
{
    RecyclerView recycler_view_clinics;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinics);
        setupViews();
    }
    private void setupViews() { }
}
