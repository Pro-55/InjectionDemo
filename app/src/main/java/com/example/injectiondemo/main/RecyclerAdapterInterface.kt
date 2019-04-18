package com.example.injectiondemo.main

import android.support.v7.widget.CardView

interface RecyclerAdapterInterface {
    fun itemClickedAt(index: Int, targetView: CardView)
}
