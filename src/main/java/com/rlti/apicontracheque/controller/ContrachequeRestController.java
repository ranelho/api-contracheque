package com.rlti.apicontracheque.controller;

import com.rlti.apicontracheque.application.ContrachequeApi;
import com.rlti.apicontracheque.request.SimulacaoInssRequest;
import com.rlti.apicontracheque.service.ContrachequeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ContrachequeRestController implements ContrachequeApi {
    private final ContrachequeService contrachequeService;

    @Override
    public String gerarContracheque(SimulacaoInssRequest simulacaoInssRequest) {
        return contrachequeService.gerarContracheque(simulacaoInssRequest);
    }
}
