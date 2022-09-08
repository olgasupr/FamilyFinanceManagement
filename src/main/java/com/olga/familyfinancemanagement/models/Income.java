package com.olga.familyfinancemanagement.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@AllArgsConstructor
@Data
@Setter(AccessLevel.NONE)
public class Income {

    double amount;
}
