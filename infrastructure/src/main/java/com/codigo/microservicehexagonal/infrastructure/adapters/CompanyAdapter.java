package com.codigo.microservicehexagonal.infrastructure.adapters;

import com.codigo.microservicehexagonal.domain.aggregates.constants.Constants;
import com.codigo.microservicehexagonal.domain.aggregates.dto.CompanyDTO;
import com.codigo.microservicehexagonal.domain.aggregates.response.ResponseCompany;
import com.codigo.microservicehexagonal.domain.ports.out.CompanyServiceOut;
import com.codigo.microservicehexagonal.infrastructure.dao.CompanyRepository;
import com.codigo.microservicehexagonal.infrastructure.entity.CompanyEntity;
import com.codigo.microservicehexagonal.infrastructure.mapper.CompanyMapper;
import com.codigo.microservicehexagonal.infrastructure.rest.SunatClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CompanyAdapter implements CompanyServiceOut {
    private final CompanyRepository companyRepository;
    private final SunatClient sunatClient;
    private final CompanyMapper companyMapper;

    @Value("${token.api}")
    private String token;

    @Override
    public CompanyDTO createCompanyOut(String ruc) {
        CompanyEntity companyEntity = getEntity(ruc);
        return companyMapper.mapToDto(companyRepository.save(companyEntity));
    }

    private CompanyEntity getEntity(String ruc) {
        ResponseCompany responseCompany = execute(ruc);

        if (Objects.nonNull(responseCompany)) {
            return CompanyEntity
                    .builder()
                    .razonSocial(responseCompany.getRazonSocial())
                    .tipoDocumento(responseCompany.getTipoDocumento())
                    .numeroDocumento(responseCompany.getNumeroDocumento())
                    .estado(responseCompany.getEstado())
                    .condicion(responseCompany.getCondicion())
                    .direccion(responseCompany.getDireccion())
                    .ubigeo(responseCompany.getUbigeo())
                    .viaTipo(responseCompany.getViaTipo())
                    .viaNombre(responseCompany.getViaNombre())
                    .zonaCodigo(responseCompany.getZonaCodigo())
                    .zonaTipo(responseCompany.getZonaTipo())
                    .numero(responseCompany.getNumero())
                    .interior(responseCompany.getInterior())
                    .lote(responseCompany.getLote())
                    .dpto(responseCompany.getDpto())
                    .manzana(responseCompany.getManzana())
                    .kilometro(responseCompany.getKilometro())
                    .distrito(responseCompany.getDistrito())
                    .provincia(responseCompany.getProvincia())
                    .departamento(responseCompany.getDepartamento())
                    .esAgenteRetencion(responseCompany.getEsAgenteRetencion())
                    .tipo(responseCompany.getTipo())
                    .actividadEconomica(responseCompany.getActividadEconomica())
                    .numeroTrabajadores(responseCompany.getNumeroTrabajadores())
                    .tipoFacturacion(responseCompany.getTipoFacturacion())
                    .tipoContabilidad(responseCompany.getTipoContabilidad())
                    .comercioExterior(responseCompany.getComercioExterior())
                    .fechaCreacion(new Timestamp(System.currentTimeMillis()))
                    .creadoPor(Constants.CREATED_USER)
                    .build();
        }

        return null;
    }

    private ResponseCompany execute(String ruc) {
        String header = "Bearer " + token;
        return sunatClient.getInfoCompany(header, ruc);
    }
}
