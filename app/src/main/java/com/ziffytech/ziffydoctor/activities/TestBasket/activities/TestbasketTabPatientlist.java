package com.ziffytech.ziffydoctor.activities.TestBasket.activities;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziffytech.ziffydoctor.R;
import com.ziffytech.ziffydoctor.activities.DrawerMenu.fragments.TabFragment;
import com.ziffytech.ziffydoctor.activities.TestBasket.fragment.TestBasketTabFragment;
import com.ziffytech.ziffydoctor.commanclass.CommonActivity;
import java.util.ArrayList;
import java.util.List;

public class TestbasketTabPatientlist extends CommonActivity
{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int mHour, mMinute;
    private int mDay, mMonth, mYear, msec;
    TestBasketTabFragment todayFragment;
    TestBasketTabFragment monthFragment;
    TestBasketTabFragment weekFragment;
    TextView text_from_date, text_to_date;
    ImageView img_from_date, img_to_date;
    String to_date,from_date;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testbasket_tab_patientlist);
        allowBack();
        setHeaderTitle("Accounts");
        setupViews();

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
        todayFragment =  TestBasketTabFragment.newInstance();
        weekFragment =  TestBasketTabFragment.newInstance();
        monthFragment =  TestBasketTabFragment.newInstance();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(todayFragment, "Today");
        adapter.addFragment(weekFragment, "Week");
        adapter.addFragment(monthFragment, "Month");
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

