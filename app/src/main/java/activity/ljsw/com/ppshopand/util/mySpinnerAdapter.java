package activity.ljsw.com.ppshopand.util;


import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import activity.ljsw.com.ppshopand.R;


public class mySpinnerAdapter extends BaseAdapter{
    private Context context;
    private List<String> list;
    private LayoutInflater layoutInflater;
    private ViewHolder viewHolder = null;
    private int size;

    public mySpinnerAdapter(Context context, List<String> list) {
        super();
        this.context = context;
        this.list = list;
        this.size=14;
        layoutInflater = LayoutInflater.from(context);

    }

    public mySpinnerAdapter(Context context, List<String> list, int size) {
        super();
        this.context = context;
        this.list = list;
        this.size=size;
        layoutInflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        return list.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.spinner_title, null);
            viewHolder = new ViewHolder();
            convertView.setTag(viewHolder);
            viewHolder.tv=(TextView) convertView.findViewById(R.id.spinner_tv);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv.setText(list.get(position));
        viewHolder.tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
        return convertView;
    }

    public static class ViewHolder {
        public TextView tv;
    }



}