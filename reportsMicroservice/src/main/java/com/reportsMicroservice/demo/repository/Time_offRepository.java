package com.reportsMicroservice.demo.repository;

import com.reportsMicroservice.demo.model.Time_off;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Time_offRepository extends JpaRepository<Time_off, Integer> {
}
