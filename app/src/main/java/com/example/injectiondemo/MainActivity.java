package com.example.injectiondemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import toothpick.Scope;
import toothpick.Toothpick;

public class MainActivity extends AppCompatActivity {

    @Inject
    Context mContext;
    @Inject
    ArrayList<Integer> dataList;

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Open desired scope
        Scope appScope = Toothpick.openScope(getString(R.string.string_app_scope_name));
        Toothpick.inject(this, appScope);

        RecyclerView idRvItemRecyclerView = findViewById(R.id.idRvItemRecyclerView);
        idRvItemRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        idRvItemRecyclerView.setAdapter(new RecyclerAdapter(mContext, dataList));
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(idRvItemRecyclerView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Close opened scope
        Toothpick.closeScope(getString(R.string.string_app_scope_name));
    }
}
