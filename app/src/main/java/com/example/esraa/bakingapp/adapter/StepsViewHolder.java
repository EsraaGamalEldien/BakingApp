package com.example.esraa.bakingapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.esraa.bakingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StepsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.step_short_description_text_view)
    TextView shortDescTextView;
    @BindView(R.id.step_long_description_text_view)
    TextView longDescTextView;
    @BindView(R.id.details_step_card_view)
    CardView detailsStepCardView;

    public StepsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
