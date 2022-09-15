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

    @Query(nativeQuery = true, value = "SELECT * FROM period WHERE from_date <= CURDATE() AND to_date >= CURDATE()")
    Optional<Period> findCurrentPeriod();

}
