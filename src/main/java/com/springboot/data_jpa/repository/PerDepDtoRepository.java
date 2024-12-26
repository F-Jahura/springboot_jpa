package com.springboot.data_jpa.repository;

import com.springboot.data_jpa.entity.PerDepDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerDepDtoRepository extends JpaRepository<PerDepDto, Integer> {
}
