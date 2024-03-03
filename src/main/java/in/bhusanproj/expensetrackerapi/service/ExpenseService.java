package in.bhusanproj.expensetrackerapi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import in.bhusanproj.expensetrackerapi.entity.Expense;

public interface ExpenseService {
	
	Page<Expense> getAllExpenses(Pageable page);
	Expense getExpenseById(Long id);
	void delExpenseById(Long id);
	void saveExpense(Expense expense);
	Expense updateExpense(Long id,Expense expense);
	List<Expense> readByCategory(String Category, Pageable page);
	List<Expense> readByNameContaining(String keyword, Pageable page);
	List<Expense> readByDateBetween(Date start,Date end, Pageable page);
	List<Expense> getAllExpensesByUserId(Long userId, Pageable page);

}
