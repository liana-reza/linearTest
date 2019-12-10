package com.sample.android.lineartestapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.android.lineartestapplication.Adapter.MenuRecyclerViewAdapter;
import com.sample.android.lineartestapplication.Model.MenuModel;

import java.util.ArrayList;
import java.util.List;

public class LaunchActivity extends AppCompatActivity implements View.OnClickListener, MenuRecyclerViewAdapter.OnItemClicked {
    DrawerLayout drawerLayout;
    ImageView btnMenu;
    RecyclerView drawerRecycler;
    MenuRecyclerViewAdapter adapter;
    List<MenuModel> list = new ArrayList<>();
    TextView txtProfileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        initViews();
        click();
    }

    private void click() {
        btnMenu.setOnClickListener(this);
    }

    private void fillList() {
        MenuModel model = new MenuModel();
        model.setMenuImageId(R.drawable.ic_profile);
        model.setMenuText("Sign Up");
        list.add(model);
        model = new MenuModel();
        model.setMenuImageId(R.drawable.ic_dial);
        model.setMenuText("Dial");
        list.add(model);
    }

    private void initViews() {
        drawerLayout = findViewById(R.id.drawerLayout);
        btnMenu = findViewById(R.id.btnMenu);
        drawerRecycler = findViewById(R.id.drawerRecycler);
        fillList();
        drawerRecycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new MenuRecyclerViewAdapter(list);
        adapter.setOnClick(this);
        drawerRecycler.setAdapter(adapter);
        txtProfileName = findViewById(R.id.txtProfileName);
        if (!PreferenceManager.getDefaultSharedPreferences(this).getString(Const.TAG_NAME, "").equals(""))
            txtProfileName.setText(PreferenceManager.getDefaultSharedPreferences(this).getString(Const.TAG_NAME, "") + " " +
                    PreferenceManager.getDefaultSharedPreferences(this).getString(Const.TAG_LASTNAME, ""));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMenu:
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
        }
    }

    @Override
    public void onItemClick(int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, DialActivity.class));
                break;
        }

    }
}
