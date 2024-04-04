package com.rlti.apicontracheque.service;

import com.rlti.apicontracheque.response.ContrachequeResponse;
import com.rlti.apicontracheque.utils.ConvertString;
import lombok.experimental.UtilityClass;
import net.sf.jasperreports.engine.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static com.rlti.apicontracheque.utils.ConvertString.*;

@UtilityClass
public class JasperReports {

    public static String gerarContrachequeBase64(ContrachequeResponse contrachequeResponse) {
        try {
            InputStream templateStream = JasperReports.class.getResourceAsStream("/templates/contracheque.jrxml");

            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);

            Map<String, Object> parameters = getStringObjectMap(contrachequeResponse);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
            byte[] pdfBytes = baos.toByteArray();

            return Base64.getEncoder().encodeToString(pdfBytes);
        } catch (Exception e) {
            return "Erro ao gerar relatório: " + e.getMessage();
        }
    }

    private static Map<String, Object> getStringObjectMap(ContrachequeResponse contrachequeResponse) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nomeFuncionario", contrachequeResponse.getNomeFuncionario());
        parameters.put("cpf", contrachequeResponse.getCpf());
        parameters.put("numeroMatricula", contrachequeResponse.getNumeroMatricula());
        parameters.put("dataAdmissao", contrachequeResponse.getDataAdmissao().toString());
        parameters.put("cargo", contrachequeResponse.getCargo());
        parameters.put("setor", contrachequeResponse.getSetor());
        parameters.put("mesCompetencia", contrachequeResponse.getMesCompetencia());
        parameters.put("salarioBruto", formatarMoeda(contrachequeResponse.getSalarioBruto()));
        parameters.put("aliquota", contrachequeResponse.getAliquota());
        parameters.put("valorDescontoInss", formatarMoeda(contrachequeResponse.getValorDescontoInss()));
        parameters.put("valorDescontoIrrf", formatarMoeda(contrachequeResponse.getValorDescontoIrrf()));
        parameters.put("fgts", formatarMoeda(contrachequeResponse.getFgts()));
        parameters.put("salarioLiquido", formatarMoeda(contrachequeResponse.getSalarioLiquido()));
        return parameters;
    }
}
