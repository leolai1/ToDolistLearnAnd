package com.leolai.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 15-9-24.
 */
public class ToDoItemAdapter extends ArrayAdapter<ToDoItem> {

    private int mResource;
    public ToDoItemAdapter(Context context, int resource, List<ToDoItem> objects) {
        super(context, resource, objects);
        this.mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout listView;

        ToDoItem item = getItem(position);
        String taskName = item.getTastName();
        Date mDate = item.getCreateDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        String mDateString = sdf.format(mDate);

        if (convertView == null) {
            listView = new RelativeLayout(getContext());
            LayoutInflater lf = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            lf.inflate(mResource, listView, true);
        } else {
            listView = (RelativeLayout)convertView;
        }
        TextView mNameView = (TextView) listView.findViewById(R.id.task_name_id);
        mNameView.setText(taskName);
        TextView mDateView = (TextView) listView.findViewById(R.id.create_date_id);
        mDateView.setText(mDateString);

        return listView;
    }


}
