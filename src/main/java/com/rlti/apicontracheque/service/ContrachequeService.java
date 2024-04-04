package com.rlti.apicontracheque.service;

import com.rlti.apicontracheque.request.SimulacaoInssRequest;

public interface ContrachequeService {
    String gerarContracheque(SimulacaoInssRequest simulacaoInssRequest);
}
