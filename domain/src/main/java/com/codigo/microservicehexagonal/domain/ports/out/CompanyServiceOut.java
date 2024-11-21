package com.codigo.microservicehexagonal.domain.ports.out;

import com.codigo.microservicehexagonal.domain.aggregates.dto.CompanyDTO;

public interface CompanyServiceOut {
    CompanyDTO createCompanyOut(String ruc);
}
