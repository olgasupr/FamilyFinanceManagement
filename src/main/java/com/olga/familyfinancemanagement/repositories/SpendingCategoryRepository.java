package com.olga.familyfinancemanagement.repositories;

import com.olga.familyfinancemanagement.models.SpendingCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendingCategoryRepository extends CrudRepository<SpendingCategory, Integer> {

}
