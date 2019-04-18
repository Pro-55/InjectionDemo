package com.example.injectiondemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Integer> dataList;

    public RecyclerAdapter(Context mContext, ArrayList<Integer> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_recycler_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int index) {
        viewHolder.idTvItemText.setText(String.valueOf(index));
        if (index % 6 == 0) {
            viewHolder.idCvParentCard.setCardBackgroundColor(mContext.getResources().getColor(R.color.colorMint));
        } else if (index % 5 == 0) {
            viewHolder.idCvParentCard.setCardBackgroundColor(mContext.getResources().getColor(R.color.colorLime));
        } else if (index % 4 == 0) {
            viewHolder.idCvParentCard.setCardBackgroundColor(mContext.getResources().getColor(R.color.colorCoral));
        } else if (index % 3 == 0) {
            viewHolder.idCvParentCard.setCardBackgroundColor(mContext.getResources().getColor(R.color.colorLily));
        } else if (index % 2 == 0) {
            viewHolder.idCvParentCard.setCardBackgroundColor(mContext.getResources().getColor(R.color.colorBlush));
        } else {
            viewHolder.idCvParentCard.setCardBackgroundColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView idCvParentCard;
        AppCompatTextView idTvItemText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idCvParentCard = itemView.findViewById(R.id.idCvParentCard);
            idTvItemText = itemView.findViewById(R.id.idTvItemText);
        }
    }
}
