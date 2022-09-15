package com.olga.familyfinancemanagement.services;

import com.olga.familyfinancemanagement.models.ActualSpending;
import com.olga.familyfinancemanagement.repositories.ActualSpendingRepository;
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

    public List<ActualSpending> getActualSpendingsForMonth(Date month) {
        Date thisMonth = getFirstDayOfMonth(month);
        Date nextMonth = addMonths(thisMonth, 1);
        return actualSpendingRepository.findBySpendingDateGreaterThanEqualAndSpendingDateLessThan(
                thisMonth, nextMonth);
    }
}
