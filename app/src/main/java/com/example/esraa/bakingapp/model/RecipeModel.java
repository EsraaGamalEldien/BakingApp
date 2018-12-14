package com.example.esraa.bakingapp.model;

import java.io.Serializable;
import java.util.List;

public class RecipeModel implements Serializable {
    private List<Ingredients> ingredients;

    private String id;

    private String servings;

    private String name;

    private String image;

    private List<Steps> steps;

    public List<Ingredients> getIngredients ()
    {
        return ingredients;
    }

    public void setIngredients (List<Ingredients> ingredients)
    {
        this.ingredients = ingredients;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getServings ()
    {
        return servings;
    }

    public void setServings (String servings)
    {
        this.servings = servings;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public List<Steps> getSteps ()
    {
        return steps;
    }

    public void setSteps (List<Steps> steps)
    {
        this.steps = steps;
    }

}
