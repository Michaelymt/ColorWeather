package com.cerezalab.colorweather.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cerezalab.colorweather.Day;
import com.cerezalab.colorweather.R;

import java.util.ArrayList;

/**
 * Created by LUIS on 17/04/2017.
 */

public class DailyWeatherAdapter extends BaseAdapter {

    public static final String TAG = DailyWeatherAdapter.class.getSimpleName();

    ArrayList<Day> days;
    Context context;

    public DailyWeatherAdapter(Context context, ArrayList<Day> days){

        this.context = context;
        this.days = days;
    }

    @Override
    public int getCount() {
        if(days == null)
            return 0;
        return days.size();

    }

    @Override
    public Object getItem(int position) {
        return days.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0; //No lo usaremos
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        Day day = days.get(position);

        if(view == null) {
            Log.d(TAG, "Creando vista y buscando vistas");

            view = LayoutInflater.from(context).inflate(R.layout.daily_list_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.dayTitle = (TextView) view.findViewById(R.id.dailyListTitle);
            viewHolder.dayDescription = (TextView)  view.findViewById(R.id.dailyListDescription);
            viewHolder.dayRainProbability =  (TextView) view.findViewById(R.id.dailyListProbability);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.dayTitle.setText(day.getDayName());
        viewHolder.dayDescription.setText(day.getWeatherDescription());
        viewHolder.dayRainProbability.setText(day.getRainProbability());

        return view;
    }

    static class ViewHolder{

        TextView dayTitle;
        TextView dayDescription;
        TextView dayRainProbability;

    }
}
