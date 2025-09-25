package com.demo.Cash_Compass.dto;

import com.demo.Cash_Compass.entity.Transaction;

import java.util.List;
import java.util.Map;

public class DashboardData {
    private double totalIncome;
    private double totalExpense;
    private double totalBalance;
    private Map<Integer, Double> expenseByCategory;
    private Map<String, Map<String, Double>> dailyTransactions;
    private List<Transaction> recentTransactions;

    public DashboardData(double totalIncome, double totalExpense, double totalBalance, Map<Integer, Double> expenseByCategory, Map<String, Map<String, Double>> dailyTransactions, List<Transaction> recentTransactions) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.totalBalance = totalBalance;
        this.expenseByCategory = expenseByCategory;
        this.dailyTransactions = dailyTransactions;
        this.recentTransactions = recentTransactions;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public Map<Integer, Double> getExpenseByCategory() {
        return expenseByCategory;
    }

    public void setExpenseByCategory(Map<Integer, Double> expenseByCategory) {
        this.expenseByCategory = expenseByCategory;
    }

    public Map<String, Map<String, Double>> getDailyTransactions() {
        return dailyTransactions;
    }

    public void setDailyTransactions(Map<String, Map<String, Double>> dailyTransactions) {
        this.dailyTransactions = dailyTransactions;
    }

    public List<Transaction> getRecentTransactions() {
        return recentTransactions;
    }

    public void setRecentTransactions(List<Transaction> recentTransactions) {
        this.recentTransactions = recentTransactions;
    }
}
