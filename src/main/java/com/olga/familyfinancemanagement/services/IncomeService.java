package com.olga.familyfinancemanagement.services;

import com.olga.familyfinancemanagement.models.Income;
import com.olga.familyfinancemanagement.repositories.IncomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public double getIncomeByPeriodId(final int periodId) {
        return incomeRepository.findByPeriod_Id(periodId).orElse(new Income()).getAmount();
    }

}
