package com.rlti.apicontracheque.controller;

import com.rlti.apicontracheque.application.ContrachequeApi;
import com.rlti.apicontracheque.request.ContrachequeRequest;
import com.rlti.apicontracheque.service.ContrachequeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ContrachequeRestController implements ContrachequeApi {
    private final ContrachequeService contrachequeService;

    @Override
    public String gerarContrachequeBase64(ContrachequeRequest contrachequeRequest) {
        return contrachequeService.gerarContracheque(contrachequeRequest);
    }

    @Override
    public ResponseEntity<byte[]> gerarContrachequePdf(ContrachequeRequest contrachequeRequest) {
        return contrachequeService.gerarContracheque2(contrachequeRequest);
    }
}
