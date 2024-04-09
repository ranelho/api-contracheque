package com.rlti.apicontracheque.response;

import java.time.LocalDate;

public record EmpresaDetalhadoResponse(
        Long idEmpresa,
        String razaoSocial,
        String nomeFantasia,
        String cnpj,
        String nomeAdministrador,
        String inscricaoMunicipal,
        String areaAtuacao,
        LocalDate dataAbertura,
        String email,
        String telefone,
        String enderecoComercial
) {
}
