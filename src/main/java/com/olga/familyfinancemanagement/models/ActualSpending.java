package com.olga.familyfinancemanagement.models;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Data
@Setter(AccessLevel.NONE)
public class ActualSpending {
    private int id;
    private SpendingCategory spendingCategory;
    private double amount;
    private Date date;

    public String getSpendingCategoryName() {
        return spendingCategory.getCategoryName();
    }
}
