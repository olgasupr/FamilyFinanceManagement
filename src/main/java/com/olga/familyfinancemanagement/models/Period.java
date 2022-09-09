package com.olga.familyfinancemanagement.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter(AccessLevel.PRIVATE)
@Entity
@Table(name = "period")
public class Period {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
}
