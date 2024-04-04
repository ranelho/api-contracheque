package com.rlti.apicontracheque.service;

import com.rlti.apicontracheque.request.SimulacaoInssRequest;
import org.springframework.http.ResponseEntity;

public interface ContrachequeService {
    String gerarContracheque(SimulacaoInssRequest simulacaoInssRequest);

    ResponseEntity<byte[]> gerarContracheque2(SimulacaoInssRequest simulacaoInssRequest);
}
