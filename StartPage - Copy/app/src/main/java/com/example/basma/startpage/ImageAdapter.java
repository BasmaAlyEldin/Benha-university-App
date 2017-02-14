package com.example.basma.startpage;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by basma on 1/20/2017.
 */
public class ImageAdapter  extends BaseAdapter {

    Context context;
    private int layoutResourceId;
    List<ViewHolder> ArrayOfData =new ArrayList<>();
    LayoutInflater inflater;


    public ImageAdapter(Context context,int layoutResourceId,List ArrayOfData)
    {

        this.context= context;
       this.layoutResourceId=layoutResourceId;
        this.ArrayOfData=ArrayOfData;



    }

    @Override
    public int getCount() {
        return ArrayOfData.size();

    }

    @Override
    public ViewHolder getItem(int i) {
       return ArrayOfData.get(i);

    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View v=view;
        ImageView img ;
        TextView t;
        if(v==null)
        {


            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            v = inflater.inflate(R.layout.griditem, null);
            img=(ImageView)v.findViewById(R.id.grid_item_image) ;
             t=(TextView)v.findViewById(R.id.grid_item_title);



        }
        else
        {
            img = (ImageView)v.findViewById(R.id.grid_item_image);
            t=(TextView)v.findViewById(R.id.grid_item_title);
        }
        img = (ImageView) v.findViewById(R.id.grid_item_image);
        img.setImageResource(ArrayOfData.get(i).getid());
         t.setText(ArrayOfData.get(i).gettitle());
        return v;
    }

}
