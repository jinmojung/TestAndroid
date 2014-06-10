package kr.codesolutions.recalldetail.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

import kr.codesolutions.recalldetail.R;
import kr.codesolutions.recalldetail.common.Const;
import kr.codesolutions.recalldetail.vo.MultiSelectVo;

public class MultiSelectAdapter extends BaseAdapter {

    private List<MultiSelectVo> multiSelectVoList = new ArrayList<MultiSelectVo>();
    private Context context;
    private int layout;
    private LayoutInflater inflater;

    public MultiSelectAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<MultiSelectVo> multiSelectVoList) {
        this.multiSelectVoList = multiSelectVoList;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return multiSelectVoList.size();
    }

    @Override
    public MultiSelectVo getItem(int position) {
        return multiSelectVoList.get(position);
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
        final MultiSelectVo multiSelectVo = getItem(position);

        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
        checkBox.setText(multiSelectVo.getLabel());
//        if(multiSelectVo.isSelected()){
//            Log.d(Const.TAG, "multiSelectVo.getLabel()" + multiSelectVo.getLabel() + "isSelected");
//            checkBox.setChecked(true);
//        }else{
//            Log.d(Const.TAG, "multiSelectVo.getLabel()"+multiSelectVo.getLabel()+"not isSelected");
//            checkBox.setChecked(false);
//        }
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(multiSelectVo.isSelected()){
//                    Log.d(Const.TAG, "multiSelectVo.getLabel()" + multiSelectVo.getLabel() + "isSelected" + multiSelectVo);
//                    multiSelectVo.setSelected(false);
//                }else{
//                    multiSelectVo.setSelected(true);
//                }
            }
        });



        return convertView;
    }
}
