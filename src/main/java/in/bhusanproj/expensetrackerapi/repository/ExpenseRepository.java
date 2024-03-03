package in.bhusanproj.expensetrackerapi.repository;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bhusanproj.expensetrackerapi.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	Page<Expense> findByCategory(String Category, Pageable page);
	Page<Expense> findByNameContaining(String keyword, Pageable page);
	Page<Expense> findByDateBetween(Date start,Date end, Pageable page);
	Page<Expense> findByUserId(Long userId, Pageable page);
	
}
