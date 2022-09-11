package com.olga.familyfinancemanagement.services;

import com.olga.familyfinancemanagement.models.Income;
import com.olga.familyfinancemanagement.models.Period;
import com.olga.familyfinancemanagement.repositories.IncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class IncomeService {

    private final PeriodService periodService;
    private final IncomeRepository incomeRepository;

    public Income getCurrentIncome() {
        final Period currentPeriod = periodService.getCurrentPeriod();
        return incomeRepository.findByPeriod_Id(currentPeriod.getId())
                .orElseGet(() -> incomeRepository.save(new Income(null, 0, currentPeriod)));
    }

    public double getIncomeByPeriodId(final int periodId) {
        return incomeRepository.findByPeriod_Id(periodId).orElse(new Income()).getAmount();
    }

    @Transactional
    public void createOrUpdateIncome(final double amount) {

        final Period currentPeriod = periodService.getCurrentPeriod();
        incomeRepository.findByPeriod_Id(currentPeriod.getId())
                .ifPresentOrElse(
                        (income) -> {
                            incomeRepository.updateIncomeAmount(income.getId(), amount);
                        }, () -> {
                            incomeRepository.save(new Income(null, amount, currentPeriod));
                        });
    }

}
