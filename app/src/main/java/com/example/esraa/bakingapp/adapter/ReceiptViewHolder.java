package com.example.esraa.bakingapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.esraa.bakingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReceiptViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.recipe_title_text_view)
    TextView receiptTitleTextView;
    public ReceiptViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
