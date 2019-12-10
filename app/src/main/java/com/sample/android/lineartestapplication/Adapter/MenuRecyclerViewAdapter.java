package com.sample.android.lineartestapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.android.lineartestapplication.Holder.MenuViewHolder;
import com.sample.android.lineartestapplication.Model.MenuModel;
import com.sample.android.lineartestapplication.R;

import java.util.List;

/**
 * Created by A.mehdizadeh on 10,December,2019
 */
public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    List<MenuModel> list;
    private OnItemClicked onClick;

    public MenuRecyclerViewAdapter(List<MenuModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_recycler_item, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, final int position) {
        holder.imgMenuItem.setImageResource(list.get(position).getMenuImageId());
        holder.txtMenuItem.setText(list.get(position).getMenuText());
        holder.txtMenuItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(position);
            }
        });
    }

    public void setOnClick(OnItemClicked onClick) {
        this.onClick = onClick;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClicked {
        void onItemClick(int position);
    }

}
