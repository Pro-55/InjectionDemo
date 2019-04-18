package com.example.injectiondemo.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.injectiondemo.R
import kotlinx.android.synthetic.main.layout_vertical_recycler_item.view.*
import java.util.*

class RecyclerAdapter(private val mContext: Context, private val dataList: ArrayList<Int>, private val recyclerAdapterInterface: RecyclerAdapterInterface) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_vertical_recycler_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
        viewHolder.itemView.idTvItemText.text = index.toString()
        when {
            index % 6 == 0 -> viewHolder.itemView.idCvParentCard.setCardBackgroundColor(mContext.resources.getColor(dataList[0]))
            index % 5 == 0 -> viewHolder.itemView.idCvParentCard.setCardBackgroundColor(mContext.resources.getColor(dataList[1]))
            index % 4 == 0 -> viewHolder.itemView.idCvParentCard.setCardBackgroundColor(mContext.resources.getColor(dataList[2]))
            index % 3 == 0 -> viewHolder.itemView.idCvParentCard.setCardBackgroundColor(mContext.resources.getColor(dataList[3]))
            index % 2 == 0 -> viewHolder.itemView.idCvParentCard.setCardBackgroundColor(mContext.resources.getColor(dataList[4]))
            else -> viewHolder.itemView.idCvParentCard.setCardBackgroundColor(mContext.resources.getColor(dataList[5]))
        }
        viewHolder.itemView.setOnClickListener {
            recyclerAdapterInterface.itemClickedAt(index, viewHolder.itemView.idCvParentCard)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
