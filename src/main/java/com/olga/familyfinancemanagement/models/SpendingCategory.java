package com.olga.familyfinancemanagement.models;

import lombok.*;

@AllArgsConstructor
@Data
@Setter(AccessLevel.NONE)
public class SpendingCategory {
    int id;
    String categoryName;
}
