package com.rlti.apicontracheque.utils;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@UtilityClass
public class ConvertString {
    public static String formatarMoeda(BigDecimal valor) {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat formato = new DecimalFormat("R$ #,##0.00", simbolos);
        return formato.format(valor);
    }

    public static String formatarCpfCnpj(String cpfCnpj) {
        if (cpfCnpj == null || cpfCnpj.isEmpty()) {
            return "";
        }

        cpfCnpj = cpfCnpj.replaceAll("[^0-9]", "");
        if (cpfCnpj.length() == 11) {
            return formatarCpf(cpfCnpj);
        }
        else if (cpfCnpj.length() == 14) {
            return formatarCnpj(cpfCnpj);
        }
        else {
            return cpfCnpj;
        }
    }

    private static String formatarCpf(String cpf) {
        return cpf.substring(0, 3) + "." +
                cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" +
                cpf.substring(9);
    }

    private static String formatarCnpj(String cnpj) {
        return cnpj.substring(0, 2) + "." +
                cnpj.substring(2, 5) + "." +
                cnpj.substring(5, 8) + "/" +
                cnpj.substring(8, 12) + "-" +
                cnpj.substring(12);
    }

    public static String formatarData(LocalDate data) {
        if (data == null) {
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return data.format(formatter);
    }

    public static String formatarMesAno(String mesAno) {
        if (mesAno == null || mesAno.isEmpty()) {
            return "";
        }

        YearMonth yearMonth = YearMonth.parse(mesAno + "-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        return yearMonth.format(formatter);
    }
}
