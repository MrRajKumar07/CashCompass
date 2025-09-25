package com.demo.Cash_Compass.controller;

import com.demo.Cash_Compass.entity.SharedTransaction;
import com.demo.Cash_Compass.service.SharedTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/shared-transactions")
public class SharedTransactionController {

    @Autowired
    private SharedTransactionService sharedTransactionService;

    @GetMapping
    public List<SharedTransaction> getSharedTransactions(Principal principal) {
        return sharedTransactionService.getSharedTransactionsForUser(principal.getName());
    }

    @PostMapping
    public ResponseEntity<SharedTransaction> createSharedTransaction(@RequestBody SharedTransaction sharedTransaction, Principal principal) {
        SharedTransaction newExpense = sharedTransactionService.saveSharedTransaction(principal.getName(), sharedTransaction);
        return ResponseEntity.ok(newExpense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SharedTransaction> updateSharedTransaction(@PathVariable Long id, @RequestBody SharedTransaction updatedExpense, Principal principal) {
        SharedTransaction expense = sharedTransactionService.updateSharedTransaction(principal.getName(), id, updatedExpense);
        return ResponseEntity.ok(expense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSharedTransaction(@PathVariable Long id, Principal principal) {
        sharedTransactionService.deleteSharedTransaction(principal.getName(), id);
        return ResponseEntity.noContent().build();
    }
}
