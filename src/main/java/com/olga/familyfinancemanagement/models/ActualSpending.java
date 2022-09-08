package com.olga.familyfinancemanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActualSpending {
    int id;
    SpendingCategory spendingCategory;
    double amount;
    Date date;
}
