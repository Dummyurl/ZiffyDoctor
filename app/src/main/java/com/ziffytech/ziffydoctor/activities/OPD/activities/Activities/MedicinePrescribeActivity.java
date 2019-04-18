package com.ziffytech.ziffydoctor.activities.OPD.activities.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ziffytech.ziffydoctor.R;

public class MedicinePrescribeActivity extends AppCompatActivity
{

    TextView text_med_type;
    TextView text_before_meal, text_after_meal;
    View view_before, view_after;
    boolean isBeforeMeal = false;
    Button buttonNext;
    ImageView img_morn, img_aft, img_eve, img_night;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_prescribe);
        setupViews();
        text_med_type.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showMedicineTypeDialog();
            }
        });

        text_before_meal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                isBeforeMeal = true;
                view_before.setVisibility(View.VISIBLE);
                view_after.setVisibility(View.GONE);
                text_before_meal.setTextColor(getResources().getColor(R.color.dark_grey));
                text_after_meal.setTextColor(getResources().getColor(R.color.grey_light));
            }
        });
        text_after_meal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                isBeforeMeal = false;
                view_after.setVisibility(View.VISIBLE);
                view_before.setVisibility(View.GONE);
                text_after_meal.setTextColor(getResources().getColor(R.color.dark_grey));
                text_before_meal.setTextColor(getResources().getColor(R.color.grey_light));
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MedicinePrescribeActivity.this, TestPrescribeActivity.class));
            }
        });

        img_morn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img_morn.setImageDrawable(getResources().getDrawable(R.drawable.ic_selected_rb));
            }
        });

        img_aft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img_aft.setImageDrawable(getResources().getDrawable(R.drawable.ic_selected_rb));
            }
        });

        img_eve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img_eve.setImageDrawable(getResources().getDrawable(R.drawable.ic_selected_rb));
            }
        });

        img_night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                img_night.setImageDrawable(getResources().getDrawable(R.drawable.ic_selected_rb));
            }
        });
    }


    private void showMedicineTypeDialog() {

        AlertDialog.Builder builderSingle = new AlertDialog.Builder(MedicinePrescribeActivity.this);
        builderSingle.setTitle("Select Type");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MedicinePrescribeActivity.this, android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("Tab");
        arrayAdapter.add("Cap");
        arrayAdapter.add("Syp");
        builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }

        });

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = arrayAdapter.getItem(which);
                AlertDialog.Builder builderInner = new AlertDialog.Builder(MedicinePrescribeActivity.this);
                builderInner.setMessage(strName);
                text_med_type.setText(strName);
            }
        });
        builderSingle.show();


    }

    private void setupViews() {

        text_med_type = findViewById(R.id.text_med_type);
        text_after_meal = findViewById(R.id.text_after_meal);
        text_before_meal = findViewById(R.id.text_before_meal);
        view_before = findViewById(R.id.view_before_meal);
        view_after = findViewById(R.id.view_after_meal);
        buttonNext = findViewById(R.id.buttonNext);
        img_morn = findViewById(R.id.img_morn);
        img_aft = findViewById(R.id.img_aft);
        img_eve = findViewById(R.id.img_eve);
        img_night = findViewById(R.id.img_night);

    }
}
