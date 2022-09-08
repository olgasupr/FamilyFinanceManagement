package com.olga.familyfinancemanagement.repositories;

import com.olga.familyfinancemanagement.models.ActualSpending;
import com.olga.familyfinancemanagement.models.SpendingCategory;

import java.util.*;

public class ActualSpendingRepo {

    SpendingCategoryRepo _spendingCategoryRepo;

    public ActualSpendingRepo(SpendingCategoryRepo spendingCategoryRepo) {
        _spendingCategoryRepo = spendingCategoryRepo;
    }

    public List<ActualSpending> getLatestSpending() {

        //TODO:  read from database here

        List<SpendingCategory> spendingCategories = _spendingCategoryRepo.getAllCategories();

        return Arrays.asList(
                new ActualSpending(1, spendingCategories.get(0), 25,
                        new GregorianCalendar(2022, Calendar.FEBRUARY, 11).getTime()),
                new ActualSpending(2, spendingCategories.get(1), 100,
                        new GregorianCalendar(2022, Calendar.SEPTEMBER, 2).getTime()),
                new ActualSpending(3, spendingCategories.get(0), 89,
                        new GregorianCalendar(2022, Calendar.SEPTEMBER, 6).getTime())
        );
    }
}
