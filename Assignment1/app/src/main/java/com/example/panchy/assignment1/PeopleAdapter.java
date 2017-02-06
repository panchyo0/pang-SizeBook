/*
 * Copyright (c) 2017 CMPUT 301. University of Alberta - All rights reserved. You may use,
 * distribute, or modify this code under terms and conditions of Code of Student Behaviour at
 * University of Alberta. You can find a copy of the lisence in this project. Otherwise please
 * contact qpang@ualberta.ca
 */

package com.example.panchy.assignment1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * This class is an PeopleAdapter class of the people. <br> In this class,
 * i override getcount, getitem,getitemid and getview methods. In getview i will
 * get the name, bust, chest, waist and inseam of people and show it on the main activity.
 *
 * @author pang qi
 * @version 1.1
 * @since 1.0
 */

public class PeopleAdapter extends BaseAdapter {

    private Context context;
    private List<People> peopleList;

    /**
     * creat a new peopleadapter
     * @param context
     * @param peopleList
     */
    public PeopleAdapter(Context context, List<People> peopleList) {
        this.context = context;
        this.peopleList = peopleList;
    }

    /**
     * get the size of peoplelist
     * @return size
     */
    @Override
    public int getCount() {
        return peopleList.size();
    }

    /**
     * get the item in the position of peoplelist
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return peopleList.get(position);
    }

    /**
     * get the position
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * set the people information in main activity
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(context,R.layout.name_items,null);
        TextView name=(TextView) v.findViewById(R.id.nameItem);

        name.setText(peopleList.get(position).getName() + "\nBust:" + peopleList.get(position).getBust()
                    + " Chest:" + peopleList.get(position).getChest() + " Waist:" + peopleList.get(position).getWaist()
                    + " Inseam:" + peopleList.get(position).getInseam());
        name.setTextSize(20);


        v.setTag(peopleList.get(position));
        return v;
    }
}
