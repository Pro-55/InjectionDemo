package com.example.injectiondemo

import java.util.ArrayList

import toothpick.config.Module

class ModuleProvider {
    private val dataList = ArrayList<Int>()

    fun dataModule(): Module {
        setDataList()
        return object : Module() {
            init {
                bind(ArrayList::class.java).toInstance(dataList)
            }
        }
    }

    private fun setDataList() {
        for (i in 0..999) {
            dataList.add(R.color.colorMint)
            dataList.add(R.color.colorLime)
            dataList.add(R.color.colorCoral)
            dataList.add(R.color.colorLily)
            dataList.add(R.color.colorBlush)
            dataList.add(R.color.colorPrimaryDark)
        }
    }
}
