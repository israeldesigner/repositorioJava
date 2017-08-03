package br.edu.evolucao.relatorio;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.io.IOUtils;

public class ReportService {

	public static void main(String[] args) throws FileNotFoundException, JRException {
		
		ReportService reportService = new ReportService();
		InputStream jasperInputStream = reportService.findRelatorio("listagem.jasper");
		byte[] bytes = reportService.getBytes(jasperInputStream, new ArrayList<Object>(), null);
		System.out.println(bytes);
		
	}
	
	public InputStream findRelatorio(File file) throws FileNotFoundException {
		FileInputStream fileInput = new FileInputStream(file);
		return fileInput;
	}
	
	public InputStream findRelatorio(String path) {
		return this.getClass().getClassLoader().getResourceAsStream(path);
	}
	
	public <T> byte[] getBytes(InputStream relatorio, List<T> list, Map<String,Object> parameters) throws JRException {    
         
	     /* Cria o design apartir do reportStream */    
	     JasperReport jasperReport = (JasperReport) JRLoader.loadObject(relatorio);    
	         
	     /* Cria um JRBeanCollection a partir de um list fornecido */    
	     JRBeanCollectionDataSource lista = new JRBeanCollectionDataSource(list);    
	         
	     /* Prepara o relatorio para impressao */    
	     JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, lista);    
	         
	     return JasperExportManager.exportReportToPdf(jasperPrint);
	     
	} 
	
	public <T> void genarateReport(InputStream relatorio, List<T> list, Map<String,Object> parameters, OutputStream outputStream) throws JRException {
		
		 /* Cria o design apartir do reportStream */    
	     JasperReport jasperReport = (JasperReport) JRLoader.loadObject(relatorio);    
	         
	     /* Cria um JRBeanCollection a partir de um list fornecido */    
	     JRBeanCollectionDataSource lista = new JRBeanCollectionDataSource(list);    
	         
	     /* Prepara o relatorio para impressao */    
	     JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, lista);    

	     /* Gerar relatório */
	     JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);    
		
	}
	
	public void genarateReport(byte[] bytes, OutputStream outputStream) throws IOException {
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, outputStream);
	}
	
}
