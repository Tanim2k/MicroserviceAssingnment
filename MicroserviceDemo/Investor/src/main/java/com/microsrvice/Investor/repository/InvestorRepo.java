package com.microsrvice.Investor.repository;

import com.microsrvice.Investor.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvestorRepo extends JpaRepository<Investor,Long> {
    Optional<Investor> findByInvestCode(Long id);
}
