package com.ziffytech.ziffydoctor.activities.OPD.activities.Activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ziffytech.ziffydoctor.R;

public class PaymentActivity extends AppCompatActivity
{
    TextView text_cheque, text_cash, text_POS;
    boolean isPOS=false,isCheque=false,isCash=false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setupViews();
        text_cash.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v)
            {
                isCash=true;
                isPOS=false;
                isCheque=false;
                text_cash.setBackground(getResources().getDrawable(R.drawable.bg_payment_type_selected));
                text_cash.setTextColor(getResources().getColor(R.color.white));
                text_POS.setBackground(getResources().getDrawable(R.drawable.bg_payment_type_unselected));
                text_POS.setTextColor(getResources().getColor(R.color.payment_text_color));
                text_cheque.setBackground(getResources().getDrawable(R.drawable.bg_payment_type_unselected));
                text_cheque.setTextColor(getResources().getColor(R.color.payment_text_color));
            }
        });
        text_cheque.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                isCash = false;
                isPOS = false;
                isCheque = true;
                text_cheque.setBackground(getResources().getDrawable(R.drawable.bg_payment_type_selected));
                text_cheque.setTextColor(getResources().getColor(R.color.white));
                text_cash.setBackground(getResources().getDrawable(R.drawable.bg_payment_type_unselected));
                text_cash.setTextColor(getResources().getColor(R.color.payment_text_color));
                text_POS.setBackground(getResources().getDrawable(R.drawable.bg_payment_type_unselected));
                text_POS.setTextColor(getResources().getColor(R.color.payment_text_color));

            }
        });
        text_POS.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v)
            {
                isCash=false;
                isPOS=true;
                isCheque=false;
                text_POS.setBackground(getResources().getDrawable(R.drawable.bg_payment_type_selected));
                text_POS.setTextColor(getResources().getColor(R.color.white));
                text_cash.setBackground(getResources().getDrawable(R.drawable.bg_payment_type_unselected));
                text_cash.setTextColor(getResources().getColor(R.color.payment_text_color));
                text_cheque.setBackground(getResources().getDrawable(R.drawable.bg_payment_type_unselected));
                text_cheque.setTextColor(getResources().getColor(R.color.payment_text_color));

            }
        });

    }

    private void selectedOption(TextView textView) { }

    private void setupViews()
    {
        text_cash = findViewById(R.id.text_cash);
        text_cheque = findViewById(R.id.text_cheque);
        text_POS = findViewById(R.id.text_pos);
    }
}
