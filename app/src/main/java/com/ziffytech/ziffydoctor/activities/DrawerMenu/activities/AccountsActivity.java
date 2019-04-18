package com.ziffytech.ziffydoctor.activities.DrawerMenu.activities;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.ziffytech.ziffydoctor.R;
import com.ziffytech.ziffydoctor.activities.DrawerMenu.fragments.TabFragment;

import java.util.ArrayList;
import java.util.List;

public class AccountsActivity extends AppCompatActivity
{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int mHour, mMinute;
    private int mDay, mMonth, mYear, msec;
    TabFragment todayFragment;
    TabFragment monthFragment;
    TabFragment weekFragment;
    TabFragment yearFragment;
    TextView text_from_date, text_to_date;
    ImageView img_from_date, img_to_date;
    String to_date,from_date;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        setupViews();
        img_from_date.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AccountsActivity.this,R.style.DialogTheme,
                        new DatePickerDialog.OnDateSetListener()
                        {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                            {
                                text_from_date.setText((dayOfMonth)+ "/" + (monthOfYear+1) + "/" + year);

                                from_date=(dayOfMonth)+ "-" + (monthOfYear+1) + "-" + year;
                            }}, mYear, mMonth, mDay);

                datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
                {
                    @Override
                    public void onCancel(DialogInterface dialog)
                    {
                        finish();
                    }
                });
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
        img_to_date.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AccountsActivity.this,R.style.DialogTheme,
                        new DatePickerDialog.OnDateSetListener()
                        {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                            {
                                text_to_date.setText((dayOfMonth)+ "/" + (monthOfYear+1) + "/" + year);
                                to_date=(dayOfMonth)+ "-" + (monthOfYear+1) + "-" + year;
                            }}, mYear, mMonth, mDay);
                datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
                {
                    @Override
                    public void onCancel(DialogInterface dialog)
                    {
                        finish();
                    }
                });
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
    }


    private void setupViews()
    {
        text_to_date = findViewById(R.id.text_to_date);
        text_from_date = findViewById(R.id.text_from_date);
        img_from_date = findViewById(R.id.img_from_date);
        img_to_date = findViewById(R.id.img_to_date);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager)
    {
        todayFragment = TabFragment.newInstance();
        weekFragment = TabFragment.newInstance();
        monthFragment = TabFragment.newInstance();
        yearFragment = TabFragment.newInstance();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(todayFragment, "Today");
        adapter.addFragment(weekFragment, "Week");
        adapter.addFragment(monthFragment, "Month");
        adapter.addFragment(yearFragment, "Year");
        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }
        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFragment(Fragment fragment, String title)
        {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
