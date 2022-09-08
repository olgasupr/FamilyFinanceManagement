package com.olga.familyfinancemanagement.repositories;

import com.olga.familyfinancemanagement.models.Income;

public class IncomeRepo {

    public IncomeRepo() {

    }

    public Income getIncome() {
        //TODO:  read from database
        return new Income(999);
    }
}
