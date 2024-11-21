package com.codigo.microservicehexagonal.infrastructure.mapper;

import com.codigo.microservicehexagonal.domain.aggregates.dto.CompanyDTO;
import com.codigo.microservicehexagonal.infrastructure.entity.CompanyEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public CompanyDTO mapToDto(CompanyEntity companyEntity) {
        return MODEL_MAPPER.map(companyEntity, CompanyDTO.class);
    }

    public CompanyEntity mapToEntity(CompanyDTO companyDTO) {
        return MODEL_MAPPER.map(companyDTO, CompanyEntity.class);
    }
}
