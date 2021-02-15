package com.polimigo.pos.pos.expenses.services.expensesService;

import com.polimigo.pos.pos.bluPrint.BluePrintService;
import com.polimigo.pos.pos.expenses.models.Expenses;
import com.polimigo.pos.pos.expenses.models.ExpensesCategory;

/**
 * @author michael wagih
 */
public interface ExpensesService extends BluePrintService<Expenses> {
    Expenses createExpenses(Expenses expenses, Long categoryId);
}
