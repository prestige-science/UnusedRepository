package com.prestige;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Banks, Integer> {
    List<Banks> findByCodeContaining(String text);
}
