package com.olga.familyfinancemanagement.repositories;

import com.olga.familyfinancemanagement.models.Period;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface PeriodRepository extends CrudRepository<Period, Integer> {

    //Optional<Income> findByPeriod_Id(final Integer periodId);

    @Query(nativeQuery = true, value = "SELECT * FROM period WHERE from_date <= :date AND to_date > :date")
    Optional<Period> findPeriodForDate(@Param("date")Date date);

}
