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
}
