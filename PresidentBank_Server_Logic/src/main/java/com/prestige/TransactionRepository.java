package com.prestige;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
    List<Transactions> findBySerialContainingOrCreatedContaining(String text, String textAgain);
}
