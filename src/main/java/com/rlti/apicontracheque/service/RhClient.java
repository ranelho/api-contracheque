package com.rlti.apicontracheque.service;

import com.rlti.apicontracheque.request.ContrachequeRequest;
import com.rlti.apicontracheque.response.ContrachequeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "rhClient", url = "${rhClient.url}")
public interface RhClient {

    @GetMapping("v1/contracheque/funcionario")
    ContrachequeResponse getContracheque(@RequestBody ContrachequeRequest contrachequeRequest);
}