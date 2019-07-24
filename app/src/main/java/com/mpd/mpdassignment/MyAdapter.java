// Name                 __Ian Campbell_____
// Student ID           __200507045________
// Programme of Study   ___ITMB____________
//

package com.mpd.mpdassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter <ListItemObjects> {
    ListItemObjects aItem;

    public MyAdapter(Context context, ArrayList<ListItemObjects> itemObjects){
        super(context, R.layout.weather_list, itemObjects);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View List_view = inflater.inflate(R.layout.weather_list, parent, false);

        aItem = getItem(position);

        TextView dayTextView = (TextView) List_view.findViewById(R.id.dayTextView);
        TextView lowTextView = (TextView) List_view.findViewById(R.id.lowTextView);
        TextView highTextView = (TextView) List_view.findViewById(R.id.highTextView);
        TextView humidityTextView = (TextView) List_view.findViewById(R.id.humidityTextView);

        dayTextView.setText(aItem.getForecast());
        lowTextView.setText(aItem.getMinTemp());
        highTextView.setText(aItem.getMaxTemp());
        humidityTextView.setText(aItem.getHumidity());

        return List_view;

    }
}
