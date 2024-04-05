package com.rlti.apicontracheque.service;

import com.rlti.apicontracheque.request.ContrachequeRequest;
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
    public String gerarContracheque(ContrachequeRequest contrachequeRequest) {
        ContrachequeResponse contrachequeResponse = rhClient.getContracheque(contrachequeRequest);
        return JasperReports.gerarContrachequeBase64(contrachequeResponse);
    }

    @Override
    public ResponseEntity<byte[]> gerarContracheque2(ContrachequeRequest contrachequeRequest) {
        ContrachequeResponse contrachequeResponse = rhClient.getContracheque(contrachequeRequest);
        byte[] pdfBytes = JasperReports.gerarContrachequePdf(contrachequeResponse);
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }


}
