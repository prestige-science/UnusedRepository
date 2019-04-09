package com.prestige;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRespository extends JpaRepository<Accounts, Integer> {
    List<Accounts> findByAmountContainingOrTypeContaining(String text, String textAgain);
}