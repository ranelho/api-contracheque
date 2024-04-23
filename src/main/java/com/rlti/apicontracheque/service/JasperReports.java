package com.rlti.apicontracheque.service;

import com.rlti.apicontracheque.response.ContrachequeResponse;
import com.rlti.apicontracheque.response.DescontosResponse;
import com.rlti.apicontracheque.response.VencimentosResponse;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.*;

import static com.rlti.apicontracheque.utils.ConvertString.*;

@UtilityClass
@Slf4j
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
        parameters.put("nomeFuncionario", contrachequeResponse.nomeFuncionario());
        parameters.put("cpf", formatarCpfCnpj(contrachequeResponse.cpf()));
        parameters.put("numeroMatricula", contrachequeResponse.numeroMatricula());
        parameters.put("dataAdmissao", formatarData(contrachequeResponse.dataAdmissao()));
        parameters.put("cargo", contrachequeResponse.cargo());
        parameters.put("setor", contrachequeResponse.setor());
        parameters.put("mesCompetencia", formatarMesAno(contrachequeResponse.mesCompetencia()));
        parameters.put("fgts", formatarMoeda(contrachequeResponse.fgts()));
        parameters.put("salarioBruto", formatarMoeda(contrachequeResponse.salarioBruto()));
        parameters.put("salarioLiquido", formatarMoeda(contrachequeResponse.salarioLiquido()));
        parameters.put("totalDescontos", formatarMoeda(contrachequeResponse.totalDescontos()));
        parameters.put("totalVencimentos", formatarMoeda(contrachequeResponse.totalVencimentos()));
        parameters.put("empresa", contrachequeResponse.empresa().nomeFantasia());
        parameters.put("cnpj", formatarCpfCnpj(contrachequeResponse.empresa().cnpj()));
        parameters.put("banco", contrachequeResponse.banco());
        parameters.put("agencia", contrachequeResponse.agencia());
        parameters.put("conta", contrachequeResponse.conta());
        parameters.put("dataPagamento", contrachequeResponse.dataPagamento() != null ? formatarData(contrachequeResponse.dataPagamento()) : "");
        parameters.put("ctps", contrachequeResponse.ctps());

        List<DescontosResponse> descontosArray = contrachequeResponse.descontos();
        JRBeanCollectionDataSource descontosDataSource = new JRBeanCollectionDataSource(descontosArray);
        parameters.put("descontosDataSet", descontosDataSource);

        List<VencimentosResponse> vencimentosArray = contrachequeResponse.vencimentos();
        JRBeanCollectionDataSource vencimentosDataSource = new JRBeanCollectionDataSource(vencimentosArray);
        parameters.put("vencimentosDataSet", vencimentosDataSource);

        return parameters;
    }

    public static byte[] gerarContrachequePdf(ContrachequeResponse contrachequeResponse) {
        try {
            InputStream templateStream = JasperReports.class.getResourceAsStream("/templates/contracheque.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);
            Map<String, Object> parameters = getStringObjectMap(contrachequeResponse);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
            return baos.toByteArray();
        } catch (Exception e) {
            log.error("Error generating payslip PDF", e);
            return new byte[0];
        }
    }
}
