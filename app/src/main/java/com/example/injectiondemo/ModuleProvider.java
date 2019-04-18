package com.example.injectiondemo;

import java.util.ArrayList;

import toothpick.config.Module;

public class ModuleProvider {
    private ArrayList<Integer> dataList = new ArrayList<>();

    public Module dataModule() {
        setDataList();
        return new Module() {{
            bind(ArrayList.class).toInstance(dataList);
        }};
    }

    private void setDataList() {
        for (int i = 0; i < 1000; i++) {
            dataList.add(R.color.colorMint);
            dataList.add(R.color.colorLime);
            dataList.add(R.color.colorCoral);
            dataList.add(R.color.colorLily);
            dataList.add(R.color.colorBlush);
            dataList.add(R.color.colorPrimaryDark);
        }
    }
}
