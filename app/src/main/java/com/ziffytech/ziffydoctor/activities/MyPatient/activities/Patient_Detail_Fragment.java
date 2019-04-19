package com.ziffytech.ziffydoctor.activities.MyPatient.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ziffytech.ziffydoctor.R;
import com.ziffytech.ziffydoctor.activities.MyPatient.adapter.PatientDetailAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hugeterry(http://hugeterry.cn)
 */
public class Patient_Detail_Fragment extends Fragment {
    private RecyclerView mRecyclerView;

    private List<String> mDatas;
    private static final String ARG_TITLE = "title";
    private String mTitle;

    public static Patient_Detail_Fragment getInstance(String title) {
        Patient_Detail_Fragment fra = new Patient_Detail_Fragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);
        fra.setArguments(bundle);
        return fra;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mTitle = bundle.getString(ARG_TITLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_patient_detail, container, false);

        initData();
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.setAdapter(new PatientDetailAdapter(mRecyclerView.getContext(), mDatas));




        return v;
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add(mTitle + (char) i);
        }
    }

}