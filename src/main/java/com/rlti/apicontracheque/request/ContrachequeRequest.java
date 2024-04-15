package com.rlti.apicontracheque.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ContrachequeRequest(
        @NotBlank(message = "Mes competência é obrigatório!")
        @Pattern(regexp = "^(?:\\d{4})-(?:0[1-9]|1[0-2])$", message = "Formato de ano-mês inválido")
        String mesAno,
        @NotBlank(message = "Número de matricula é obrigatório!")
        String matricula
) {
}
