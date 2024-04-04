package com.rlti.apicontracheque.service;

import com.rlti.apicontracheque.response.ContrachequeResponse;
import lombok.experimental.UtilityClass;
import net.sf.jasperreports.engine.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class JasperReports {

    public static String gerarContrachequeBase64(ContrachequeResponse contrachequeResponse) {
        try {
            // Carregar o template JRXML
            InputStream templateStream = JasperReports.class.getResourceAsStream("/templates/contracheque.jrxml");

            // Compilar o template JRXML
            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);

            // Adicionar os dados para o relatório
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("nomeFuncionario", contrachequeResponse.getNomeFuncionario());
            parameters.put("cpf", contrachequeResponse.getCpf());
            parameters.put("numeroMatricula", contrachequeResponse.getNumeroMatricula());
            parameters.put("mesCompetencia", contrachequeResponse.getMesCompetencia());
            parameters.put("dataAdmissao", contrachequeResponse.getDataAdmissao().toString());
            parameters.put("cargo", contrachequeResponse.getCargo());
            parameters.put("setor", contrachequeResponse.getSetor());

            // Gerar o relatório em PDF
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            // Converter o PDF para um array de bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
            byte[] pdfBytes = baos.toByteArray();

            // Converter o array de bytes para Base64
            return Base64.getEncoder().encodeToString(pdfBytes);
        } catch (Exception e) {
            return "Erro ao gerar relatório: " + e.getMessage();
        }
    }
}
