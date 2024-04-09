package com.rlti.apicontracheque.application;

import com.rlti.apicontracheque.request.ContrachequeRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("v1/contracheque")
public interface ContrachequeApi {

    @PostMapping("/funcionario")
    @ResponseStatus(HttpStatus.OK)
    String gerarContrachequeBase64(@Valid @RequestBody ContrachequeRequest contrachequeRequest);

    @PostMapping("/funcionario/pdf")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<byte[]> gerarContrachequePdf(@Valid @RequestBody ContrachequeRequest contrachequeRequest) ;
}
