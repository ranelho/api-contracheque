package com.rlti.apicontracheque.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ContrachequeResponse {
    String nomeFuncionario;
    String cpf;
    String numeroMatricula;
    LocalDate dataAdmissao;
    String cargo;
    String setor;
    String mesCompetencia;
    BigDecimal salarioBruto;
    int quantidadeDependentes;
    double aliquota;
    BigDecimal valorDescontoInss;
    BigDecimal valorDescontoIrrf;
    BigDecimal fgts;
    BigDecimal salarioLiquido;
}
