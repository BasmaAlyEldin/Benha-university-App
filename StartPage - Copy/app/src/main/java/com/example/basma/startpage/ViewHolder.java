package com.example.basma.startpage;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by basma on 1/20/2017.
 */
public class ViewHolder {
   String titleTextView;
    int imageViewid;

    public void settitle (String title)
    {
        titleTextView=title;
    }

    public void setid (int id)
    {
        imageViewid=id;
    }

    public String gettitle ()
    {
       return titleTextView;
    }

    public int getid ()
    {
        return imageViewid;
    }
}
