package com.rlti.apicontracheque.service;

import com.rlti.apicontracheque.request.ContrachequeRequest;
import com.rlti.apicontracheque.response.ContrachequeResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ContentDisposition;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpHeaders;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContrachequeApplicationService implements ContrachequeService {

    private final RhClient rhClient;

    @Override
    public String gerarContracheque(ContrachequeRequest contrachequeRequest) {
        try {
            ContrachequeResponse contrachequeResponse = rhClient.getContracheque(contrachequeRequest);
            return JasperReports.gerarContrachequeBase64(contrachequeResponse);
        } catch (FeignException e) {
            return String.valueOf(new Exception(e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<byte[]> gerarContracheque2(ContrachequeRequest contrachequeRequest) {
        try {
            ContrachequeResponse contrachequeResponse = rhClient.getContracheque(contrachequeRequest);
            byte[] pdfBytes = JasperReports.gerarContrachequePdf(contrachequeResponse);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("contracheque.pdf").build());

            return ResponseEntity.ok().headers(headers).body(pdfBytes);
        } catch (FeignException e) {
            return ResponseEntity.status(e.status()).body(e.getMessage().getBytes());
        }
    }


}
