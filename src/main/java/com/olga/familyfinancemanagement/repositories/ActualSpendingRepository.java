package com.olga.familyfinancemanagement.repositories;

import com.olga.familyfinancemanagement.models.ActualSpending;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ActualSpendingRepository extends CrudRepository<ActualSpending, Integer> {

    List<ActualSpending> findBySpendingDateGreaterThanEqualAndSpendingDateLessThanEqual(final Date fromDate, final Date toDate);
}
