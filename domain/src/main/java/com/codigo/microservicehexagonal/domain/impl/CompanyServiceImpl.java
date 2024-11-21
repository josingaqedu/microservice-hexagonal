package com.codigo.microservicehexagonal.domain.impl;

import com.codigo.microservicehexagonal.domain.aggregates.dto.CompanyDTO;
import com.codigo.microservicehexagonal.domain.ports.in.CompanyServiceIn;
import com.codigo.microservicehexagonal.domain.ports.out.CompanyServiceOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyServiceIn {
    private final CompanyServiceOut companyServiceOut;

    @Override
    public CompanyDTO createCompanyIn(String ruc) {
        return companyServiceOut.createCompanyOut(ruc);
    }
}
