package com.rlti.apicontracheque.service;

import com.rlti.apicontracheque.request.SimulacaoInssRequest;
import com.rlti.apicontracheque.response.ContrachequeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContrachequeApplicationService implements ContrachequeService {

    private final RhClient rhClient;

    @Override
    public String gerarContracheque(SimulacaoInssRequest simulacaoInssRequest) {
        ContrachequeResponse contrachequeResponse = rhClient.getContracheque(simulacaoInssRequest);
        return JasperReports.gerarContrachequeBase64(contrachequeResponse);
    }


}
