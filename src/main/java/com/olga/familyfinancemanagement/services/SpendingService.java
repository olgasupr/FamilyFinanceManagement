package com.olga.familyfinancemanagement.services;

import com.olga.familyfinancemanagement.models.ActualSpending;
import com.olga.familyfinancemanagement.models.SpendingCategory;
import com.olga.familyfinancemanagement.models.TargetSpending;
import com.olga.familyfinancemanagement.repositories.ActualSpendingRepository;
import com.olga.familyfinancemanagement.repositories.SpendingCategoryRepository;
import com.olga.familyfinancemanagement.repositories.TargetSpendingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.olga.familyfinancemanagement.utils.DateUtils.*;

@AllArgsConstructor
@Service
public class SpendingService {

    private final ActualSpendingRepository actualSpendingRepository;
    private final TargetSpendingRepository targetSpendingRepository;
    private final SpendingCategoryRepository spendingCategoryRepository;

    public List<ActualSpending> getActualSpendingsForMonth(Date month) {
        Date thisMonth = getFirstDayOfMonth(month);
        Date nextMonth = addMonths(thisMonth, 1);
        return actualSpendingRepository.findBySpendingDateGreaterThanEqualAndSpendingDateLessThan(
                thisMonth, nextMonth);
    }

    public List<SpendingCategory> getAllSpendingCategories() {
        return spendingCategoryRepository.findAll();
    }

    public List<TargetSpending> getAllTargetSpending() {
        return targetSpendingRepository.findAll();
    }

    public SpendingCategory getSavingsSpendingCategory() {
        return spendingCategoryRepository.findFirstByCategoryNameIgnoreCase(SpendingCategory.savingsCategoryName);
    }

    public void addActualSpending(final double amount, final Date date, final int categoryId) {
        actualSpendingRepository.save(new ActualSpending(null, amount, date, getSpendingCategory(categoryId)));
    }

    public void updateActualSpending(final int id, final double amount, final Date date, final int categoryId) {
        actualSpendingRepository.save(new ActualSpending(id, amount, date, getSpendingCategory(categoryId)));
    }

    public void deleteActualSpending(final int id) {
        actualSpendingRepository.deleteById(id);
    }

    private SpendingCategory getSpendingCategory(final int categoryId) {
        return spendingCategoryRepository.findById(categoryId).orElse(null);
    }
}
