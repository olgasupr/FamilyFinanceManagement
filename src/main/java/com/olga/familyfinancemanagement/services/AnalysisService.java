package com.olga.familyfinancemanagement.services;

import com.olga.familyfinancemanagement.models.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Service
public class AnalysisService {

    private final PeriodService periodService;
    private final IncomeService incomeService;
    private final SpendingService spendingService;

    public List<Analysis> getAnalysisForMonth(Date month) {

        final Period period = periodService.getPeriodForDate(month);
        final Income income = incomeService.getIncomeForMonth(month);
        final List<SpendingCategory> spendingCategories = spendingService.getAllSpendingCategories();
        SpendingCategory savingsCategory = spendingService.getSavingsSpendingCategory();
        final List<TargetSpending> targetSpendings = spendingService.getAllTargetSpending();
        final List<ActualSpending> actualSpendings = spendingService.getActualSpendingsForMonth(month);

        // Build targetSpendingPerCategory map
        HashMap<Integer, TargetSpending> targetSpendingPerCategory = new HashMap<>();
        for (TargetSpending ts : targetSpendings) {
            int spendingCategoryId = ts.getSpendingCategory().getId();
            targetSpendingPerCategory.put(spendingCategoryId, ts);
        }

        // BEGIN Build actualSpendingPerCategory map

        HashMap<Integer, Double> actualSpendingPerCategory = new HashMap<>();
        double totalSpent = 0;

        // first populate 0's for every spending category
        for (SpendingCategory sc : spendingCategories) {
            actualSpendingPerCategory.put(sc.getId(), 0.0);
        }

        // now add the actual spendings
        for (ActualSpending as : actualSpendings) {
            int spendingCategoryId = as.getSpendingCategory().getId();

            double amountSoFar = actualSpendingPerCategory.get(spendingCategoryId);
            amountSoFar += as.getAmount();
            actualSpendingPerCategory.put(spendingCategoryId, amountSoFar);

            totalSpent += as.getAmount();
        }

         // END Build actualSpendingPerCategory map


        // Add remainder to savings category
        double remainder = income.getAmount() - totalSpent;
        int savingsCategoryId = savingsCategory.getId();
        double savingsAmount = actualSpendingPerCategory.get(savingsCategoryId);
        savingsAmount += remainder;
        actualSpendingPerCategory.put(savingsCategoryId, savingsAmount);


        // Create analysis objects and return
        List<Analysis> analyses = new ArrayList<>();
        for (SpendingCategory sc : spendingCategories) {
            int spendingCategoryId = sc.getId();

            TargetSpending targetSpending = targetSpendingPerCategory.get(spendingCategoryId);
            double amount = actualSpendingPerCategory.get(spendingCategoryId);

            Analysis analysis = new Analysis(period, sc, income, targetSpending, amount);
            analyses.add(analysis);
        }

        // finish up
        return analyses;
    }
}