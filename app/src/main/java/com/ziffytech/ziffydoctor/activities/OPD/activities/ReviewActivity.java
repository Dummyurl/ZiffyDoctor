package com.ziffytech.ziffydoctor.activities.OPD.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ziffytech.ziffydoctor.R;

public class ReviewActivity extends AppCompatActivity
{
    Button buttonNext;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        setupViews();
        buttonNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(ReviewActivity.this, PaymentActivity.class));
            }
        });
    }

    private void setupViews()
    {
        buttonNext=findViewById(R.id.buttonNext);
    }
}
