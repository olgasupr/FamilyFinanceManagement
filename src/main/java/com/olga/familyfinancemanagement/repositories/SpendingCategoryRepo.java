package com.olga.familyfinancemanagement.repositories;

import com.olga.familyfinancemanagement.models.SpendingCategory;

import java.util.Arrays;
import java.util.List;

public class SpendingCategoryRepo {

    public SpendingCategoryRepo() {

    }

    public List<SpendingCategory> getAllCategories() {
        return Arrays.asList(
                new SpendingCategory(1, "category1"),
                new SpendingCategory(2, "category2")
        );
    }
}
