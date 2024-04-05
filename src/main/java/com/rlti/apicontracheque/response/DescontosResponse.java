package com.rlti.apicontracheque.response;

import java.math.BigDecimal;

public record DescontosResponse(
        String codigo,
        String descricao,
        BigDecimal valorDesconto
) {
}
