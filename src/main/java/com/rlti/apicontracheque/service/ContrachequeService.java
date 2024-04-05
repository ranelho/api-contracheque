package com.rlti.apicontracheque.service;

import com.rlti.apicontracheque.request.ContrachequeRequest;
import org.springframework.http.ResponseEntity;

public interface ContrachequeService {
    String gerarContracheque(ContrachequeRequest contrachequeRequest);

    ResponseEntity<byte[]> gerarContracheque2(ContrachequeRequest contrachequeRequest);
}
