package com.ziffytech.ziffydoctor.activities.Dashboard.models;

import java.io.Serializable;
import java.util.ArrayList;

public class AllMenuModel implements Serializable
{
    ArrayList<Integer> allmenus;
    public ArrayList<Integer> getAllmenus() {
        return allmenus;
    }
    public void setAllmenus(ArrayList<Integer> allmenus) {
        this.allmenus = allmenus;
    }
}
