package com.microsrvice.Entrepreneur.repository;

import com.microsrvice.Entrepreneur.entity.Entrepreneure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepreneurRepo extends JpaRepository<Entrepreneure,Long> {

    Optional<Entrepreneure> findByIdeaCode(Long id);
}
