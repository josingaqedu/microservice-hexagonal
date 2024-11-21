package com.codigo.microservicehexagonal.domain.ports.in;

import com.codigo.microservicehexagonal.domain.aggregates.dto.CompanyDTO;

public interface CompanyServiceIn {
    CompanyDTO createCompanyIn(String ruc);
}
