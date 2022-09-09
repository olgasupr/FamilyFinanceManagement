package com.olga.familyfinancemanagement.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter(AccessLevel.PRIVATE)
@Entity
@Table(name = "income")
public class Income {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "amount")
    private double amount;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "period_id", referencedColumnName = "id")
    private Period period;

}
