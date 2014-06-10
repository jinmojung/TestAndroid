package kr.codesolutions.recalldetail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kr.codesolutions.recalldetail.R;
import kr.codesolutions.recalldetail.vo.RecallDetailContent;

public class CheckBoxListAdapter extends BaseAdapter {

    private List<String> stringList = new ArrayList<String>();
    private Context context;
    private int layout;
    private LayoutInflater inflater;

    public CheckBoxListAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<String> stringList) {
        this.stringList = stringList;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public String getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        String recallDetailContent = getItem(position);
        CheckBox name = (CheckBox) convertView.findViewById(R.id.checkBox);
        name.setText(recallDetailContent);
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        String recallDetailContent = getItem(position);
        CheckBox name = (CheckBox) convertView.findViewById(R.id.checkBox);
        name.setText(recallDetailContent);
        return convertView;
    }
}
