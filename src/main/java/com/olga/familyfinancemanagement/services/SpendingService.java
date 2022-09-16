package com.olga.familyfinancemanagement.services;

import com.olga.familyfinancemanagement.models.ActualSpending;
import com.olga.familyfinancemanagement.models.SpendingCategory;
import com.olga.familyfinancemanagement.models.TargetSpending;
import com.olga.familyfinancemanagement.repositories.ActualSpendingRepository;
import com.olga.familyfinancemanagement.repositories.TargetSpendingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.olga.familyfinancemanagement.utils.DateUtils.*;

@AllArgsConstructor
@Service
public class SpendingService {

    private final ActualSpendingRepository actualSpendingRepository;
    private final TargetSpendingRepository targetSpendingRepository;

    public List<ActualSpending> getActualSpendingsForMonth(Date month) {
        Date thisMonth = getFirstDayOfMonth(month);
        Date nextMonth = addMonths(thisMonth, 1);
        return actualSpendingRepository.findBySpendingDateGreaterThanEqualAndSpendingDateLessThan(
                thisMonth, nextMonth);
    }

    public List<SpendingCategory> getAllSpendingCategories() {

        //TODO:  read from database

        return Arrays.asList(
                new SpendingCategory(64, "Food", "Groceries, restaurants, cafes, etc."),
                new SpendingCategory(65, "Personal", "Clothing, hobbies, self-care, home decor, etc."),
                new SpendingCategory(66, "Transportation", "Public transport, car payments, fuel, maintenance, etc."),
                new SpendingCategory(67, "Housing", "Mortgage, rent, fees, taxes, etc."),
                new SpendingCategory(68, "Utilities", "Gas, electric, water, internet, cell phone, etc."),
                new SpendingCategory(69, "Savings", "Retirement savings, pension funds, emergency fund, etc."),
                new SpendingCategory(70, "Insurance", "Health, house, auto, life, etc."),
                new SpendingCategory(71, "Recreation", "Travel, entertainment, lifestyle expenses, etc."),
                new SpendingCategory(72, "Giving", "Donation, etc.")
                );
    }

    public List<TargetSpending> getAllTargetSpending() {
        return null;  //TODO
    }

    public SpendingCategory getSavingsSpendingCategory() {
        return null;  //TODO
    }
}
