package com.rlti.apicontracheque.service;

import com.rlti.apicontracheque.request.SimulacaoInssRequest;
import com.rlti.apicontracheque.response.ContrachequeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @Override
    public ResponseEntity<byte[]> gerarContracheque2(SimulacaoInssRequest simulacaoInssRequest) {
        ContrachequeResponse contrachequeResponse = rhClient.getContracheque(simulacaoInssRequest);
        byte[] pdfBytes = JasperReports.gerarContrachequePdf(contrachequeResponse);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }


}
