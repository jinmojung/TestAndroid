package kr.codesolutions.landlord.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kr.codesolutions.landlord.R;
import kr.codesolutions.landlord.vo.Tenant;

public class TenantListAdapter extends BaseAdapter {

    private List<Tenant> tenantList = new ArrayList<Tenant>();
    private Context context;
    private int layout;
    private LayoutInflater inflater;

    public TenantListAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<Tenant> tenantList) {
        this.tenantList = tenantList;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return tenantList.size();
    }

    @Override
    public Tenant getItem(int position) {
        return tenantList.get(position);
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
        Tenant tenant = getItem(position);
        TextView name = (TextView) convertView.findViewById(R.id.nameTxt);
        name.setText(tenant.getName());
        TextView smsKeyWord = (TextView) convertView.findViewById(R.id.smsKeyWordTxt);
        smsKeyWord.setText(tenant.getSmsKeyWord());
        TextView price = (TextView) convertView.findViewById(R.id.priceTxt);
        price.setText(tenant.getPrice());
        return convertView;
    }
}
