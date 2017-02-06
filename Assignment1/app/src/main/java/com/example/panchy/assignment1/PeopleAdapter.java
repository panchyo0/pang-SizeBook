package com.example.panchy.assignment1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Panchy on 2017/2/1.
 */

public class PeopleAdapter extends BaseAdapter {

    private Context context;
    private List<People> peopleList;

    public PeopleAdapter(Context context, List<People> peopleList) {
        this.context = context;
        this.peopleList = peopleList;
    }

    @Override
    public int getCount() {
        return peopleList.size();
    }

    @Override
    public Object getItem(int position) {
        return peopleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

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
