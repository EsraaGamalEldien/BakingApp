package com.example.esraa.bakingapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.esraa.bakingapp.R;
import com.example.esraa.bakingapp.fragment.RecipeDetailsFragmentView;
import com.example.esraa.bakingapp.model.Steps;

import java.util.List;

public class StepsAdapter extends RecyclerView.Adapter<StepsViewHolder> {
    private List<Steps> stepsList;
    private RecipeDetailsFragmentView detailsFragmentView;

    public StepsAdapter(List<Steps> stepsList, RecipeDetailsFragmentView detailsFragmentView) {
        this.stepsList = stepsList;
        this.detailsFragmentView = detailsFragmentView;
    }

    @NonNull
    @Override
    public StepsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View rootView = inflater.inflate(R.layout.layout_step_recipe, viewGroup, false);
        return new StepsViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull StepsViewHolder stepsViewHolder, int i) {
        final Steps step = stepsList.get(i);
        stepsViewHolder.shortDescTextView.setText(step.getShortDescription());
        stepsViewHolder.longDescTextView.setText(step.getDescription());
        stepsViewHolder.detailsStepCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailsFragmentView.navigateToStepDetails(step);
            }
        });
    }


    @Override
    public int getItemCount() {
        return stepsList.size();
    }
}
