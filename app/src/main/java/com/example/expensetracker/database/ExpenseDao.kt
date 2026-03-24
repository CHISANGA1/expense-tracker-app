package com.example.expensetracker.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface ExpenseDao {
    @Query("SELECT * FROM expenses")
    List<Expense> getAllExpenses();

    @Insert
    void insertExpense(Expense expense);

    @Delete
    void deleteExpense(Expense expense);

    @Query("DELETE FROM expenses")
    void deleteAllExpenses();
}