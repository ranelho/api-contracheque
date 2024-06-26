package com.rlti.apicontracheque.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record ContrachequeResponse(
        Long idFolhaMensal,
        Long idContrato,
        Long idFuncionario,
        String ctps,
        String pis,
        String banco,
        String agencia,
        String conta,
        LocalDate dataPagamento,
        String nomeFuncionario,
        String cpf,
        String numeroMatricula,
        LocalDate dataAdmissao,
        String cargo,
        String setor,
        String mesCompetencia,
        Integer quantidadeDependentes,
        Integer diasTrabalhados,
        BigDecimal salarioBruto,
        BigDecimal valorDescontoInss,
        Double aliquotaInss,
        BigDecimal valorDescontoIrrf,
        Double aliquotaIrrf,
        BigDecimal fgts,
        BigDecimal totalVencimentos,
        BigDecimal totalDescontos,
        BigDecimal salarioLiquido,
        List<VencimentosResponse> vencimentos,
        List<DescontosResponse> descontos,
        EmpresaDetalhadoResponse empresa
) {
}
