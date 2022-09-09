package com.olga.familyfinancemanagement.repositories;

import com.olga.familyfinancemanagement.models.TargetSpending;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetSpendingRepository extends CrudRepository<TargetSpending, Integer> {
}
