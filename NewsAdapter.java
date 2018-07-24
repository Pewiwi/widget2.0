package com.example.sjonqui.ecowidget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sjonqui on 24/07/18.
 */

public class NewsAdapter extends BaseAdapter {
    private String[] Title, Detail;
    private int[] imge;
    private LayoutInflater layoutInflater;

    NewsAdapter(String s, String s1, Context context) {
        Title = null;
        Detail = null;
        imge=null;
        layoutInflater = LayoutInflater.from(context);
    }

    public NewsAdapter(String[] text, String[] text1,int[] text3, Context context) {
        Title = text;
        Detail = text1;
        imge = text3;
        layoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return Title.length;
    }

    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = layoutInflater;
        View row;
        row = inflater.inflate(R.layout.news_layout, parent, false);
        TextView title, detail;
        ImageView i1;
        title = (TextView) row.findViewById(R.id.title);
        detail = (TextView) row.findViewById(R.id.detail);
        i1=(ImageView)row.findViewById(R.id.img);
        title.setText(Title[position]);
        detail.setText(Detail[position]);
        i1.setImageResource(imge[position]);

        return (row);
    }


}
