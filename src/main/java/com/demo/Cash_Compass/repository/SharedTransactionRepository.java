package com.demo.Cash_Compass.repository;

import com.demo.Cash_Compass.entity.SharedTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SharedTransactionRepository extends JpaRepository<SharedTransaction, Long> {

    @Query("SELECT s FROM SharedTransaction s WHERE s.ownerId = :userId OR :userId MEMBER OF s.participants")
    List<SharedTransaction> findAllByOwnerOrParticipant(String userId);
}
