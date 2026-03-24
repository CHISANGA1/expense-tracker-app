package com.example.expensetracker.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.AndroidViewModel;
import android.app.Application;
import java.util.List;

public class ExpenseViewModel extends AndroidViewModel {
    private MutableLiveData<List<Expense>> expenses;
    private ExpenseRepository expenseRepository;

    public ExpenseViewModel(Application application) {
        super(application);
        expenseRepository = new ExpenseRepository(application);
        expenses = new MutableLiveData<>();
        // Initialize the LiveData with existing expenses  
        loadExpenses();
    }

    public LiveData<List<Expense>> getExpenses() {
        return expenses;
    }

    public void insert(Expense expense) {
        expenseRepository.insert(expense);
        loadExpenses(); // Update LiveData
    }

    public void delete(Expense expense) {
        expenseRepository.delete(expense);
        loadExpenses(); // Update LiveData
    }

    public void clear() {
        expenseRepository.clear();
        loadExpenses(); // Update LiveData
    }

    private void loadExpenses() {
        expenses.setValue(expenseRepository.getAllExpenses());
    }
}