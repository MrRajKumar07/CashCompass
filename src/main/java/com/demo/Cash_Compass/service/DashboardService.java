package com.demo.Cash_Compass.service;

import com.demo.Cash_Compass.dto.DashboardData;
import com.demo.Cash_Compass.entity.Category;
import com.demo.Cash_Compass.entity.Transaction;
import com.demo.Cash_Compass.repository.CategoryRepository;
import com.demo.Cash_Compass.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public DashboardData getDashboardData(String username) {
        List<Transaction> transactions = transactionRepository.findByUserIdOrderByCreatedDateDesc(username);
        List<Category> categories = categoryRepository.findByUserId(username);
        Map<Integer, Category> categoryMap = categories.stream().collect(Collectors.toMap(Category::getId, c -> c));
        
        double totalIncome = transactions.stream().filter(t -> t.getAmount() > 0).mapToDouble(Transaction::getAmount).sum();
        double totalExpense = transactions.stream().filter(t -> t.getAmount() < 0).mapToDouble(Transaction::getAmount).sum();
        double totalBalance = totalIncome + totalExpense;

        List<Transaction> recentTransactions = transactions.stream()
                .limit(5)
                .collect(Collectors.toList());

        Map<Integer, Double> expenseByCategory = transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .collect(Collectors.groupingBy(t -> t.getCategoryId() != null ? t.getCategoryId() : -1, // Use -1 for Uncategorized
                        Collectors.summingDouble(t -> Math.abs(t.getAmount())))); // Use absolute values for chart

        LocalDateTime sevenDaysAgo = LocalDateTime.now().minus(7, ChronoUnit.DAYS);
        Map<String, Map<String, Double>> dailyTransactions = transactions.stream()
                .filter(t -> t.getCreatedDate().isAfter(sevenDaysAgo))
                .collect(Collectors.groupingBy(t -> t.getCreatedDate().toLocalDate().toString(),
                        Collectors.groupingBy(t -> t.getAmount() > 0 ? "income" : "expense",
                                Collectors.summingDouble(Transaction::getAmount))));

        return new DashboardData(totalIncome, totalExpense, totalBalance, expenseByCategory, dailyTransactions, recentTransactions);
    }
}
