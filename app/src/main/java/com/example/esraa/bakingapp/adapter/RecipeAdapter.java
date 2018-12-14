package com.example.esraa.bakingapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.esraa.bakingapp.R;
import com.example.esraa.bakingapp.fragment.ReceiptsFragmentView;
import com.example.esraa.bakingapp.model.RecipeModel;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<ReceiptViewHolder> {
    private List<RecipeModel> recipeModelList;
    private ReceiptsFragmentView receiptsFragmentView;

    public RecipeAdapter(List<RecipeModel> recipeModelList, ReceiptsFragmentView receiptsFragmentView) {
        this.recipeModelList = recipeModelList;
        this.receiptsFragmentView = receiptsFragmentView;

    }

    @NonNull
    @Override
    public ReceiptViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.receipt_row_layout, viewGroup, false);
        return new ReceiptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReceiptViewHolder receiptViewHolder, int i) {
        final RecipeModel recipeModel = recipeModelList.get(i);
        receiptViewHolder.receiptTitleTextView.setText(recipeModel.getName());
        receiptViewHolder.receiptTitleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                receiptsFragmentView.navigateToRecipeDetails(recipeModel);

            }
        });
    }

    @Override
    public int getItemCount() {
        return recipeModelList.size();
    }
}
