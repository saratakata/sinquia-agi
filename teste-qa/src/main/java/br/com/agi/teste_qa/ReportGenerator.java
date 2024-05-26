package br.com.agi.teste_qa;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import br.com.agi.teste_qa.dto.ReportConfig;
import br.com.agi.teste_qa.dto.Step;
import br.com.agi.teste_qa.utils.Utils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportGenerator {
	
	
	private Collection<Step> steps = new LinkedList<Step>();
	
	private ReportConfig config;
		
	/**
	 * Construtor moderno.
	 * 
	 * @param config objeto de configuracao.
	 */
	public ReportGenerator(ReportConfig config){
		this.config = config;
	}
	
	/**
	 * Construtor classico.
	 * 
	 * @param projeto nome do projeto.
	 * @param responsavel nome do responsavel.
	 * @param outputDir diretorio de saida.
	 */
	public ReportGenerator(String projeto, String responsavel, String outputDir)
	{	
		this.config = new ReportConfig();
		this.config.setProjeto(projeto);
		this.config.setResponsavel(responsavel);
		this.config.setOutputDir(outputDir);
	}
	
	
	/**
	 * Adiciona o item a lista de passos.
	 * 
	 * @param name nome do passo
	 * @param evid inputStream da evidencia
	 */
	public void addStep(String name, InputStream evid)
	{
		Step step = new Step();
		step.setPasso(name);
		step.setEvidencia(evid);
		step.setDataexec(Utils.getDateTime());
		this.steps.add(step);
	}
	
	
	/**
	 * Define o nome do caso de teste.
	 * 
	 * @param casodeTeste nome do caso de teste.
	 */
	public void setCasodeTeste(String casodeTeste){
		this.config.setCasodeTeste(casodeTeste);
	}
	

	@SuppressWarnings("unchecked")
	/**
	 * Gerador de relatorio.
	 * 
	 * @param status status do teste,
	 */
	public void generator( String status) {
	  
		try {
			
			@SuppressWarnings("rawtypes")
			Map parameters = new HashMap();			
	        parameters.put("PROJETO", this.config.getProjeto());
	        parameters.put("RESPONSAVEL", this.config.getResponsavel());
	        parameters.put("LOGO", Utils.canonicalPath().concat("/src/main/java/br/com/agi/teste_qa/report/image/agi.png"));
	        parameters.put("DATA", Utils.getDate());
	        parameters.put("CT", this.config.getCasodeTeste());
	        parameters.put("STATUS", status);
	        
	        String outputFile = Utils.createFileName(this.config.getOutputDir(), 
					config.getCasodeTeste());
	        
	        
	        for (Step step : steps) {
				System.out.println("----------------->"+step.getPasso()+"time:"+step.getDataexec());
			}
			
			JasperPrint p = JasperFillManager.fillReport(
					ReportGenerator.class.getResourceAsStream("report/report_testecase.jasper"),parameters, 
					new JRBeanCollectionDataSource(this.steps));
			JasperExportManager.exportReportToPdfStream(p,(OutputStream) new FileOutputStream(
					outputFile));
			
			System.out.println("Report generated!:");
			System.out.println("OutputFile:"+outputFile);
	   
		} catch (JRException e) {
			e.printStackTrace();
			System.out.println("Error in ireport");
		} catch (FileNotFoundException e) {
		   System.out.println("File not found");
		   e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("General error");
		}finally {
			this.steps = new LinkedList<Step>();
		}
	}
}
