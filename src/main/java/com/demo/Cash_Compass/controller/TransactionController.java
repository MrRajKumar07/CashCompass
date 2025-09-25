package com.demo.Cash_Compass.controller;

import com.demo.Cash_Compass.entity.Transaction;
import com.demo.Cash_Compass.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:6060")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions(Principal principal) {
        String username = principal.getName();
        return transactionService.getTransactions(username);
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction, Principal principal) {
        String username = principal.getName();
        return transactionService.saveTransaction(username, transaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction, Principal principal) {
        Transaction updatedTransaction = transactionService.updateTransaction(principal.getName(), id, transaction);
        return ResponseEntity.ok(updatedTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id, Principal principal) {
        transactionService.deleteTransaction(principal.getName(), id);
        return ResponseEntity.noContent().build();
    }
}
