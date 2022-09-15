package com.olga.familyfinancemanagement.repositories;

import com.olga.familyfinancemanagement.models.Income;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IncomeRepository extends CrudRepository<Income, Integer> {

    Optional<Income> findByPeriod_Id(final Integer periodId);

    @Modifying
    @Query("UPDATE Income i set i.amount = :newAmount WHERE i.id = :incomeId")
    void updateIncomeAmount(int incomeId, double newAmount);

}
