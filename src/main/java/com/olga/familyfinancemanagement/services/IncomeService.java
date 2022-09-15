package com.olga.familyfinancemanagement.services;

import com.olga.familyfinancemanagement.models.Income;
import com.olga.familyfinancemanagement.models.Period;
import com.olga.familyfinancemanagement.repositories.IncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@AllArgsConstructor
@Service
public class IncomeService {

    private final PeriodService periodService;
    private final IncomeRepository incomeRepository;

    @Transactional
    public void createOrUpdateIncome(final Date month, final double amount) {

        final Period period = periodService.getPeriodForDate(month);
        incomeRepository.findByPeriod_Id(period.getId())
                .ifPresentOrElse(
                        (income) -> {
                            incomeRepository.updateIncomeAmount(income.getId(), amount);
                        }, () -> {
                            incomeRepository.save(new Income(null, amount, period));
                        });
    }

    public Income getIncomeForMonth(Date date) {
        final Period period = periodService.getPeriodForDate(date);
        return incomeRepository.findByPeriod_Id(period.getId())
                .orElseGet(() -> incomeRepository.save(new Income(null, 0, period)));
    }
}
