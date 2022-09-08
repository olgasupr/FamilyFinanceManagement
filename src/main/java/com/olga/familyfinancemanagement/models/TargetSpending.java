package com.olga.familyfinancemanagement.models;

import lombok.*;

@AllArgsConstructor
@Data
@Setter(AccessLevel.NONE)
public class TargetSpending {
    SpendingCategory spendingCategory;
    double targetPercentage;
}
