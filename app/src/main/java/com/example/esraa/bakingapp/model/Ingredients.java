package com.example.esraa.bakingapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ingredients implements Serializable {
    private String measure;

    private String ingredient;

    private String quantity;

    public String getMeasure ()
    {
        return measure;
    }

    public void setMeasure (String measure)
    {
        this.measure = measure;
    }

    public String getIngredient ()
    {
        return ingredient;
    }

    public void setIngredient (String ingredient)
    {
        this.ingredient = ingredient;
    }

    public String getQuantity ()
    {
        return quantity;
    }

    public void setQuantity (String quantity)
    {
        this.quantity = quantity;
    }

}
