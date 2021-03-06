package com.polimigo.pos.pos.expenses.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author michael wagih
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ExpensesCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
}
