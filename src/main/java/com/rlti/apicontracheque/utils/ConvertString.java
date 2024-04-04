package com.rlti.apicontracheque.utils;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@UtilityClass
public class ConvertString {
    public static String formatarMoeda(BigDecimal valor) {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat formato = new DecimalFormat("R$ #,##0.00", simbolos);
        return formato.format(valor);
    }
}
