package com.olga.familyfinancemanagement.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter(AccessLevel.PRIVATE)
@Entity
@Table(name = "spending_category")
public class SpendingCategory {

    public final static String savingsCategoryName = "Savings";

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "description")
    private String description;

    public boolean isSavings() {
        return savingsCategoryName.equals(categoryName);
    }
}
