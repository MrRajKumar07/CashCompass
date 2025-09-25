package com.demo.Cash_Compass.service;

import com.demo.Cash_Compass.entity.Transaction;
import com.demo.Cash_Compass.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactions(String username) {
        return transactionRepository.findByUserIdOrderByCreatedDateDesc(username);
    }

    public Transaction saveTransaction(String username, Transaction transaction) {
        transaction.setUserId(username);
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(String username, Long id, Transaction updatedTransaction) {
        return transactionRepository.findById(id).map(transaction -> {
            if (!transaction.getUserId().equals(username)) {
                throw new RuntimeException("Access denied: You can only update your own transactions.");
            }
            transaction.setDescription(updatedTransaction.getDescription());
            transaction.setAmount(updatedTransaction.getAmount());
            transaction.setCategoryId(updatedTransaction.getCategoryId());
            return transactionRepository.save(transaction);
        }).orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    public void deleteTransaction(String username, Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));
        if (!transaction.getUserId().equals(username)) {
            throw new RuntimeException("Access denied: You can only delete your own transactions.");
        }
        transactionRepository.deleteById(id);
    }
}
