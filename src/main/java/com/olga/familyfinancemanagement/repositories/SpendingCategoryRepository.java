package com.olga.familyfinancemanagement.repositories;

import com.olga.familyfinancemanagement.models.SpendingCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpendingCategoryRepository extends CrudRepository<SpendingCategory, Integer> {

    List<SpendingCategory> findAll();

    SpendingCategory findFirstByCategoryNameIgnoreCase(final String categoryName);

}
