package com.olga.familyfinancemanagement.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter(AccessLevel.PRIVATE)
@Entity
@Table(name = "target_spending")
public class TargetSpending {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "target_percent")
    private double targetPercent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private SpendingCategory spendingCategory;
}
