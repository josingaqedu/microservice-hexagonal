package com.codigo.microservicehexagonal.application.controller;

import com.codigo.microservicehexagonal.domain.aggregates.dto.CompanyDTO;
import com.codigo.microservicehexagonal.domain.ports.in.CompanyServiceIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyServiceIn companyServiceIn;

    @PostMapping("/{ruc}")
    public ResponseEntity<CompanyDTO> createCompany(@PathVariable("ruc") String ruc) {
        return ResponseEntity.ok(companyServiceIn.createCompanyIn(ruc));
    }
}
