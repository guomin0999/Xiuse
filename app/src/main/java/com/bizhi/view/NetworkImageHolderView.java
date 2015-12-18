package com.bizhi.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.koushikdutta.ion.Ion;

/**
 * Created by Administrator on 2015-12-08.
 */
public class NetworkImageHolderView implements Holder<String> {
    protected ImageView imageView;

    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    public void UpdateUI(Context context, int position, String data) {
        Ion.with(imageView).load(data);
    }
}