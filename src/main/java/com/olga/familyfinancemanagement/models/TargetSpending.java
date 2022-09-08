package com.olga.familyfinancemanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TargetSpending {
    SpendingCategory spendingCategory;
    double targetPercentage;
}
