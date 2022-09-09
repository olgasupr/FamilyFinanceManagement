package com.olga.familyfinancemanagement.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter(AccessLevel.PRIVATE)
@Entity
@Table(name = "actual_spending")
public class ActualSpending {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "spending_date")
    @Temporal(TemporalType.DATE)
    private Date spendingDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private SpendingCategory spendingCategory;

    public ActualSpending(double amount, Date spendingDate, SpendingCategory spendingCategory) {
        this.amount = amount;
        this.spendingDate = spendingDate;
        this.spendingCategory = spendingCategory;
    }
}
