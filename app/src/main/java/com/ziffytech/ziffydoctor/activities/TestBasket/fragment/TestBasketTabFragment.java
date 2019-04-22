package com.ziffytech.ziffydoctor.activities.TestBasket.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ziffytech.ziffydoctor.R;

public class TestBasketTabFragment extends Fragment
{
    public static TestBasketTabFragment newInstance()
    {
        return new TestBasketTabFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_testbasketpatintlist, container, false);
    }


}
