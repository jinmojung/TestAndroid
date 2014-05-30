package kr.codesolutions.recalldetail.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kr.codesolutions.recalldetail.R;
import kr.codesolutions.recalldetail.vo.RecallDetailContent;

public class RecallDetailContentListAdapter extends BaseAdapter {

    private List<RecallDetailContent> recallDetailContentList = new ArrayList<RecallDetailContent>();
    private Context context;
    private int layout;
    private LayoutInflater inflater;

    public RecallDetailContentListAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<RecallDetailContent> recallDetailContentList) {
        this.recallDetailContentList = recallDetailContentList;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return recallDetailContentList.size();
    }

    @Override
    public RecallDetailContent getItem(int position) {
        return recallDetailContentList.get(position);
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
        RecallDetailContent RecallDetailContent = getItem(position);
        TextView name = (TextView) convertView.findViewById(R.id.nameTxt);
        name.setText(RecallDetailContent.getModel());
        TextView smsKeyWord = (TextView) convertView.findViewById(R.id.smsKeyWordTxt);
        smsKeyWord.setText(RecallDetailContent.getHarmCause());
        TextView price = (TextView) convertView.findViewById(R.id.priceTxt);
        price.setText(RecallDetailContent.getCompanyName());
        return convertView;
    }
}
