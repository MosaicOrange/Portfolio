package com.android.pinto.monitor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

import library.src.main.java.com.jaredrummler.android.processes.models.AndroidAppProcess;

public class CustomArrayAdapter extends ArrayAdapter {
    List<AndroidAppProcess> processList;

    public CustomArrayAdapter(Context context, List<AndroidAppProcess> list) {
        super(context,0, list);
        processList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_view, parent, false);
            TextView textView = (TextView) convertView.findViewById(R.id.text1);
            String textToView = "PID: " + processList.get(position).pid + " / " + processList.get(position).name;
            textView.setText(textToView);
            return convertView;
    }
}
