package com.ziffytech.ziffydoctor.activities.OPD.OPD.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ziffytech.ziffydoctor.R;
import com.ziffytech.ziffydoctor.commanclass.CommonActivity;

public class TestPrescribeActivity extends CommonActivity
{
    Button buttonNext;
    TextView text_skip;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_prescription);
        setupViews();
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(TestPrescribeActivity.this,ReviewActivity.class));
            }
        });
        text_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(TestPrescribeActivity.this, ReviewActivity.class));
            }
        });
    }

    private void setupViews()
    {
        buttonNext=findViewById(R.id.buttonNext);
        text_skip=findViewById(R.id.text_skip);
    }
}
