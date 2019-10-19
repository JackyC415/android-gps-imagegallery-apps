package com.jackyzchen.cmpe277_lab2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {


    private Context context;

    public int[] imageArr = {

            R.drawable.sushim8,R.drawable.burger,R.drawable.cake,R.drawable.cookie,R.drawable.donut,
            R.drawable.drink0,R.drawable.drink1,R.drawable.drink2,R.drawable.chickenwings,R.drawable.crepes,
            R.drawable.fries,R.drawable.pho,R.drawable.icecream,R.drawable.sushim8,R.drawable.sushim8,
            R.drawable.sushim8,R.drawable.sushim8,R.drawable.sushim8,R.drawable.sushim8,R.drawable.sushim8
    };

    public ImageAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return imageArr.length;
    }

    @Override
    public Object getItem(int i) {
        return imageArr[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageArr[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(340,350));

        return imageView;
    }
}
