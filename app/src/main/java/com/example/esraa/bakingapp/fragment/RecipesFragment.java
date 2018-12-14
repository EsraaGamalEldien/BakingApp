package com.example.esraa.bakingapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.esraa.bakingapp.R;
import com.example.esraa.bakingapp.adapter.RecipeAdapter;
import com.example.esraa.bakingapp.model.RecipeModel;
import com.example.esraa.bakingapp.presenter.IRecipePresenter;
import com.example.esraa.bakingapp.presenter.RecipePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipesFragment extends Fragment implements ReceiptsFragmentView {
    @BindView(R.id.receipts_recycler_View)
    RecyclerView recipesRecyclerView;
    @BindView(R.id.fail_response_text_view)
    TextView failResponseTextView;
    private IRecipePresenter receiptsPresenter;
    private RecipeAdapter recipeAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_receipts, container, false);
        ButterKnife.bind(this, rootView);
        receiptsPresenter = new RecipePresenter((AppCompatActivity) getActivity(), getContext(), this);
        receiptsPresenter.callGetAllReceiptsApi();
        return rootView;
    }

    @Override
    public void viewUiWithReceiptsResponse(List<RecipeModel> recipeModelList) {
        recipesRecyclerView.setVisibility(View.VISIBLE);
        failResponseTextView.setVisibility(View.GONE);
        recipesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recipeAdapter = new RecipeAdapter(recipeModelList, this);
        recipesRecyclerView.setAdapter(recipeAdapter);
        recipeAdapter.notifyDataSetChanged();
    }

    @Override
    public void viewFailResponse() {
        recipesRecyclerView.setVisibility(View.GONE);
        failResponseTextView.setVisibility(View.VISIBLE);
        failResponseTextView.setText(R.string.fail_response_message);
    }

    @Override
    public void navigateToRecipeDetails(RecipeModel recipeModel) {
        receiptsPresenter.navigateToDetails(recipeModel);
    }
}
