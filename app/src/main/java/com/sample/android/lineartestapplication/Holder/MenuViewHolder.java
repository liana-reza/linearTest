package com.sample.android.lineartestapplication.Holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.android.lineartestapplication.R;

/**
 * Created by A.mehdizadeh on 10,December,2019
 */
public class MenuViewHolder extends RecyclerView.ViewHolder {
    public TextView txtMenuItem;
    public ImageView imgMenuItem;

    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);
        txtMenuItem = itemView.findViewById(R.id.txtMenuItem);
        imgMenuItem = itemView.findViewById(R.id.imgMenuItem);
    }
}
