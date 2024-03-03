package in.bhusanproj.expensetrackerapi.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.bhusanproj.expensetrackerapi.entity.Expense;
import in.bhusanproj.expensetrackerapi.entity.User;
import in.bhusanproj.expensetrackerapi.entity.UserModel;
import in.bhusanproj.expensetrackerapi.service.ExpenseService;
import in.bhusanproj.expensetrackerapi.service.UserService;
import jakarta.validation.Valid;

@RestController
public class ExpenceController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping(path="/expenses")
	public List<Expense> getAllExpences(Pageable page)
	{
//		System.out.println(expenseService.getAllExpenses());
		return expenseService.getAllExpenses(page).toList();
	}
	
	//PathVariable
	@GetMapping(path="/expense/{id}")
	public Expense getExpenseById(@PathVariable Long id)
	{
		
		return expenseService.getExpenseById(id);
	}
	
	//Query String /api/v1/delexpenses?id=2
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@DeleteMapping("/delexpenses")
	public String deleteExpenseById(@RequestParam Long id)
	{
		
		expenseService.delExpenseById(id);
		return "deleted id "+id;
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@PostMapping("/expense")
	public String saveExpense(@Valid @RequestBody Expense expense)
	{
		expenseService.saveExpense(expense);
		return "expense saved";
	}
	
	@PutMapping("/updateExpense/{id}")
	public Expense updateExpense(@RequestBody Expense expense, @PathVariable Long id)
	{
		return expenseService.updateExpense(id, expense);
		
	}
	@GetMapping("/expenses/category")
	public List<Expense> getExpenseByCategory(@RequestParam String category, Pageable page)
	{
		return expenseService.readByCategory(category, page);
	}
	
	
	
	
	@GetMapping("/expenses/{id}")
	public List<Expense> getExpenseByUserId(@PathVariable Long id, Pageable page)
	{
		return expenseService.getAllExpensesByUserId(id, page);
	}
	
	
	@GetMapping("/expenses/name")
	public List<Expense> getExpenseByName(@RequestParam String keyword, Pageable page)
	{
		return expenseService.readByNameContaining(keyword, page);
	}
	
	@GetMapping("/expenses/date")
	public List<Expense> getExpenseByDate(@RequestParam(required=false) Date start, 
			@RequestParam(required=false) Date end,
			Pageable page)
	{
		return expenseService.readByDateBetween(start,end,page);
	}
	
	
	

}
