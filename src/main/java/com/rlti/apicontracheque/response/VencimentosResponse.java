package com.rlti.apicontracheque.response;

import java.math.BigDecimal;

public record VencimentosResponse(
        String codigo,
        String descricao,
        BigDecimal valorDesconto
) {
}
