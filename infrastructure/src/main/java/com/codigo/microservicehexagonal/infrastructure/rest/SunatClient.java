package com.codigo.microservicehexagonal.infrastructure.rest;

import com.codigo.microservicehexagonal.domain.aggregates.response.ResponseCompany;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sunat-client", url = "https://api.apis.net.pe/v2/sunat")
public interface SunatClient {
    @GetMapping("/ruc/full")
    ResponseCompany getInfoCompany(@RequestHeader("Authorization") String token, @RequestParam("numero") String numero);
}
