package com.olga.familyfinancemanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
public class ActualSpending {
    private int id;
    private SpendingCategory spendingCategory;
    private double amount;
    private Date date;

    public String getSpendingCategoryName() {
        return spendingCategory.getCategoryName();
    }
}
