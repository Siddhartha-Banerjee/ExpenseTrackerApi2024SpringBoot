package in.bhusanproj.expensetrackerapi.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.bhusanproj.expensetrackerapi.entity.Expense;
import in.bhusanproj.expensetrackerapi.exceptions.ResourceNotFoundException;
import in.bhusanproj.expensetrackerapi.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepo;
	
	@Override
	public Page<Expense> getAllExpenses(Pageable page) {
		return expenseRepo.findAll(page);
	}
	
	public List<Expense> getAllExpensesByUserId(Long userId, Pageable page)
	{
		return expenseRepo.findByUserId(userId, page).toList();
	}

	@Override
	public Expense getExpenseById(Long id) {
		Optional<Expense> expense=expenseRepo.findById(id);
		
		if(expense.isPresent())
		{
			return expense.get();
		}
		
		throw new ResourceNotFoundException("Expense not found for id "+id);
	}

	@Override
	public void delExpenseById(Long id) {
		
		Expense expense=getExpenseById(id);
		expenseRepo.deleteById(id);
		
	}

	@Override
	public void saveExpense(Expense expense) {
		expenseRepo.save(expense);
		
	}
	
	public Expense updateExpense(Long id,Expense expense)
	{
		Expense existingExpense=getExpenseById(id);
		existingExpense.setName(expense.getName()!=null ? expense.getName():existingExpense.getName());
		existingExpense.setDescription(expense.getDescription()!=null ? expense.getDescription():existingExpense.getDescription());
		existingExpense.setCategory(expense.getCategory()!=null ? expense.getCategory():existingExpense.getCategory());
		existingExpense.setDate(expense.getDate()!=null ? expense.getDate():existingExpense.getDate());
		existingExpense.setAmount(expense.getAmount()!=null ? expense.getAmount():existingExpense.getAmount());
		return expenseRepo.save(existingExpense);
		
	}
	
	public List<Expense> readByCategory(String Category, Pageable page)
	{
		return expenseRepo.findByCategory(Category, page).toList();
	}
	
	public List<Expense> readByNameContaining(String keyword, Pageable page)
	{
		return expenseRepo.findByNameContaining(keyword, page).toList();
	}
	
	public List<Expense> readByDateBetween(Date start,Date end,Pageable page)
	{
		if(start==null)
			start=new Date(0);
		if(end==null)
			end=new Date(System.currentTimeMillis());
		return expenseRepo.findByDateBetween(start, end, page).toList();
	}

}
