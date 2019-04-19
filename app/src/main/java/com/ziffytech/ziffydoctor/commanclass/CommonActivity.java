package com.ziffytech.ziffydoctor.commanclass;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.ziffytech.ziffydoctor.R;

import cc.cloudist.acplibrary.ACProgressFlower;

/*
 * Created by subhashsanghani on 5/22/17.
 */

public abstract class CommonActivity extends AppCompatActivity {
    static ACProgressFlower progressDialog;
    public CommonClass common;
    private static KProgressHUD progressHUD;
    private TextView mLocatonTextView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        common = new CommonClass(this);
        super.onCreate(savedInstanceState);
    }
    @SuppressLint("RestrictedApi")
    public void allowBack(){
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
    public Typeface getCustomFont(){
        return  Typeface.createFromAsset(getAssets(), "LobsterTwo-BoldItalic.ttf");
    }
    public void setHeaderTitle(String title, String location){
      //  Typeface font = getCustomFont();

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.custome_header_bar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.action_bar_title);
         mLocatonTextView = (TextView) mCustomView.findViewById(R.id.action_bar_location);
        //  mTitleTextView.setTypeface(font);
        mTitleTextView.setText(title);
        mLocatonTextView.setText(location);
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        mLocatonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




              /*  try {
                    Intent intent =
                            new PlaceAutocomplete
                                    .IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                                    .build(CommonActivity.this);
                    startActivityForResult(intent, 123);
                } catch (GooglePlayServicesRepairableException e) {
                    // TODO: Handle the error.
                } catch (GooglePlayServicesNotAvailableException e) {
                    // TODO: Handle the error.
                }

                */

            }
        });

    }


    public void setHeaderTitle(){
        //  Typeface font = getCustomFont();

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.headerwithback, null);
        //TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.action_bar_title);
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);



    }

    public void setHeaderTitle(String title){
        //  Typeface font = getCustomFont();

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.custome_header_bar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.action_bar_title);
        TextView mLocatonTextView = (TextView) mCustomView.findViewById(R.id.action_bar_location);
        mTitleTextView.setText(title);
        mLocatonTextView.setVisibility(View.GONE);
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
        mActionBar.setElevation(0);
    }


    public void setProgressBarAnimation(ProgressBar progressBar1){
        ObjectAnimator animation = ObjectAnimator.ofInt (progressBar1, "progress", 0, 500); // see this max value coming back here, we animale towards that value
        animation.setDuration (5000); //in milliseconds
        animation.setInterpolator (new DecelerateInterpolator());
        animation.setRepeatCount(AlphaAnimation.INFINITE);
        animation.start ();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void showPrgressBar(){

        progressHUD =new KProgressHUD(this);
        progressHUD   //.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
               // .setLabel("Please wait")
               // .setDetailsLabel("Downloading data")
                .setCancellable(true)
                .setAnimationSpeed(2)
               // .setDimAmount(0.5f)
                .show();

       /* try
        {
            progressDialog = new ACProgressFlower.Builder(this)
                    .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                    .themeColor(Color.WHITE)
                    .text("Loading...")
                    .fadeColor(Color.DKGRAY).build();
            progressDialog.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/



    }

    public void hideProgressBar(){

        if(progressHUD.isShowing()){
           progressHUD.dismiss();

        }


       /* try
        {
            if (progressDialog != null)
            {
                progressDialog.dismiss();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/
    }



    public void startProgressDialog(Activity activity) {
       /* try
        {
            progressDialog = new ACProgressFlower.Builder(activity)
                    .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                    .themeColor(Color.WHITE)
                    .fadeColor(Color.DKGRAY).build();
            progressDialog.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/

        progressHUD =new KProgressHUD(CommonActivity.this);
        progressHUD   //.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                // .setLabel("Please wait")
                .setDetailsLabel("Loading...")
                .setCancellable(true)
                .setAnimationSpeed(3)
                // .setDimAmount(0.5f)
                .show();

    }

    public static void stopProgressDialog()
    {

        if(progressHUD.isShowing()){
            progressHUD.dismiss();

        }

      /*  try
        {
            if (progressDialog != null)
            {
                progressDialog.dismiss();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 123) {

            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                Log.e("Tag", "Place: " + place.getAddress());

                //common.setSession(ApiParams.CURRENT_CITY,place.getName()+"");
                //mLocatonTextView.setText(common.getSession(ApiParams.CURRENT_CITY));


            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                // TODO: Handle the error.
                Log.e("Tag", status.getStatusMessage());
            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }else{
            super.onActivityResult(requestCode,resultCode,data);
        }
    }


}
