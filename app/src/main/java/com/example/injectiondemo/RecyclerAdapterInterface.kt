package com.example.injectiondemo

import android.support.v7.widget.CardView

interface RecyclerAdapterInterface {
    fun itemClickedAt(index: Int, targetView: CardView)
}
