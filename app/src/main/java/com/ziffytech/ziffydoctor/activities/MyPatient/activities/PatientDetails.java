package com.ziffytech.ziffydoctor.activities.MyPatient.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.ziffytech.ziffydoctor.Coordinatorlayout.CoordinatorTabLayout;
import com.ziffytech.ziffydoctor.R;
import com.ziffytech.ziffydoctor.activities.MyPatient.adapter.PDviewpagerAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

/**
 * Created by hugeterry(http://hugeterry.cn)
 */
public class PatientDetails extends AppCompatActivity
{
    private CoordinatorTabLayout mCoordinatorTabLayout;
    private int[] mImageArray, mColorArray;
    private ArrayList<Fragment> mFragments;
    private final String[] mTitles = {"EHR", "Gallery", "Notes", "Prescription"};
    private ViewPager mViewPager;
    HorizontalCalendar horizontalCalendar;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
        initFragments();
        initViewPager();
        initToolbar();
        mImageArray = new int[]
                {
                R.drawable.bg_android,
                R.drawable.bg_ios,
                R.drawable.bg_js,
                R.drawable.bg_other};

        mColorArray = new int[]{
                R.color.fb_ligh_grey,
                R.color.fb_ligh_grey,
                R.color.fb_ligh_grey,
                R.color.fb_ligh_grey};

        mCoordinatorTabLayout = (CoordinatorTabLayout) findViewById(R.id.coordinatortablayout);
        mCoordinatorTabLayout.setTranslucentStatusBar(this)
                .setImageArray(mImageArray, mColorArray)
                .setupWithViewPager(mViewPager);
        SetBottomDate();
    }

    private void initToolbar()
    {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Patient Profile");
    }

    private void SetBottomDate()
    {
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("EEEE, MMM d, yyyy");
        String dateToStr = format.format(today);

        /* start 2 months ago from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.WEEK_OF_MONTH, 0);

        /* end after 2 months from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.WEEK_OF_MONTH, 7);

        // Default Date set to Today.
        final Calendar defaultSelectedDate = Calendar.getInstance();

        horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .configure()
                .formatTopText("EEE")
                .formatMiddleText("dd MMM")
                .formatBottomText("yyy")
                .showTopText(true)
                .showBottomText(true)
                .textColor(Color.WHITE, Color.parseColor("#ffd54f"))
                .colorTextMiddle(Color.WHITE, Color.parseColor("#ffd54f"))
                .end()
                .defaultSelectedDate(defaultSelectedDate)
                .build();

        Log.i("Default Date", DateFormat.format("EEE, MMM d, yyyy", defaultSelectedDate).toString());

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener()
        {
            @Override
            public void onDateSelected(Calendar date, int position)
            {

                String format = DateFormat.format("EEEE, MMM d, yyyy", date).toString();
                Toast.makeText(PatientDetails.this, format + " selected!", Toast.LENGTH_SHORT).show();


            }

        });
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        for (String title : mTitles) {
            mFragments.add(Patient_Detail_Fragment.getInstance(title));
        }
    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(new PDviewpagerAdapter(getSupportFragmentManager(), mFragments, mTitles));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
