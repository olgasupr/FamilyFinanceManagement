package com.olga.familyfinancemanagement.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter(AccessLevel.PRIVATE)
public class Analysis {

    private Period period;
    private SpendingCategory spendingCategory;
    private Income income;
    private TargetSpending targetSpending;
    private double actualSpendingAmount;

    public String getSpendingCategoryName() {
        return spendingCategory.getCategoryName();
    }

    public String getSpendingCategoryDescription() {
        return spendingCategory.getDescription();
    }

    public double getIncomeAmount() {
        return income.getAmount();
    }

    public double getTargetSpendingPercent() {
        return targetSpending.getTargetPercent();
    }

    public double getTargetSpendingAmount() {
        return getTargetSpendingPercent() * getIncomeAmount();
    }

    public double getActualSpendingPercent() {
        double incomeAmount = getIncomeAmount();
        if (incomeAmount < 0.01) {
            return 0.0;
        }
        return getActualSpendingAmount() / incomeAmount;
    }

    public double getExcessPercent() {
        return getActualSpendingPercent() - getTargetSpendingPercent();
    }

    public double getExcessAmount() {
        return getActualSpendingAmount() - getTargetSpendingAmount();
    }
}
