package com.codigo.microservicehexagonal.infrastructure.dao;

import com.codigo.microservicehexagonal.infrastructure.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
}
