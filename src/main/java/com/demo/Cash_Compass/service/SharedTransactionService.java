package com.demo.Cash_Compass.service;

import com.demo.Cash_Compass.entity.SharedTransaction;
import com.demo.Cash_Compass.repository.SharedTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SharedTransactionService {

    @Autowired
    private SharedTransactionRepository sharedTransactionRepository;

    public List<SharedTransaction> getSharedTransactionsForUser(String username) {
        return sharedTransactionRepository.findAllByOwnerOrParticipant(username);
    }

    public SharedTransaction saveSharedTransaction(String username, SharedTransaction sharedTransaction) {
        sharedTransaction.setOwnerId(username);
        return sharedTransactionRepository.save(sharedTransaction);
    }

    public SharedTransaction updateSharedTransaction(String username, Long id, SharedTransaction updatedExpense) {
        return sharedTransactionRepository.findById(id).map(existingExpense -> {
            if (!existingExpense.getOwnerId().equals(username)) {
                throw new RuntimeException("Access denied: You can only update your own shared expenses.");
            }
            existingExpense.setDescription(updatedExpense.getDescription());
            existingExpense.setAmount(updatedExpense.getAmount());
            existingExpense.setParticipants(updatedExpense.getParticipants());
            return sharedTransactionRepository.save(existingExpense);
        }).orElseThrow(() -> new RuntimeException("Shared expense not found"));
    }

    public void deleteSharedTransaction(String username, Long id) {
        SharedTransaction expense = sharedTransactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Shared expense not found"));
        if (!expense.getOwnerId().equals(username)) {
            throw new RuntimeException("Access denied: You can only delete your own shared expenses.");
        }
        sharedTransactionRepository.deleteById(id);
    }
}
