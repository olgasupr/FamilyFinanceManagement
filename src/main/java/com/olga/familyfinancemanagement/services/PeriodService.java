package com.olga.familyfinancemanagement.services;

import com.olga.familyfinancemanagement.models.Period;
import com.olga.familyfinancemanagement.repositories.PeriodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.olga.familyfinancemanagement.utils.DateUtils.*;

@AllArgsConstructor
@Service
public class PeriodService {

    private final PeriodRepository periodRepository;

    public Period getPeriodForDate(Date date) {
        return periodRepository.findPeriodForDate(date).orElseGet(() -> createPeriodForDate(date));
    }

    private Period createPeriodForDate(Date date) {
        Date firstOfMonth = getFirstDayOfMonth(date);
        Date nextMonth = addMonths(firstOfMonth, 1);
        return periodRepository.save(new Period(null, firstOfMonth, nextMonth));
    }

}
