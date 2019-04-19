package com.ziffytech.ziffydoctor.activities.OPD.OPD.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ziffytech.ziffydoctor.R;
import com.ziffytech.ziffydoctor.commanclass.CommonActivity;

public class VitalSignsActivity extends CommonActivity
{
    Button buttonNext;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_signs);
        setupViews();
        buttonNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(VitalSignsActivity.this, MedicinePrescribeActivity.class));
            }
        });
    }

    private void setupViews()
    {
        buttonNext=findViewById(R.id.buttonNext);
    }
}
