package com.polimigo.pos.pos.expenses.services.expesesCategory;

import com.polimigo.pos.pos.bluPrint.BluePrintService;
import com.polimigo.pos.pos.expenses.models.ExpensesCategory;

import java.util.List;

/**
 * @author michael wagih
 */
public interface ExpensesCategoryService extends BluePrintService<ExpensesCategory> {
    List<String> getAllName();

    List<ExpensesCategory> findBycategoryName(String categoryName);

}
