package br.com.agi.teste_qa.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.agi.teste_qa.ReportGenerator;
import br.com.agi.teste_qa.Status;
import br.com.agi.teste_qa.base.AbstractTestCase;
import br.com.agi.teste_qa.base.Screenshot;
import br.com.agi.teste_qa.dto.ReportConfig;
import br.com.agi.teste_qa.tela.TelaHome;
import br.com.agi.teste_qa.tela.TelaUltimasBlog;
import br.com.agi.teste_qa.utils.Utils;

public class preteste extends AbstractTestCase {
	

	TelaHome telaHome;
	TelaUltimasBlog telaUltimasBlog;

	@BeforeClass
	public static void initialize() throws InterruptedException {
		
    	
	}
	
	@Before
	public void antes() throws InterruptedException {
		telaHome = new TelaHome(driver);
		telaHome.abrirSite(url);
		telaUltimasBlog = new TelaUltimasBlog(driver);
	}

	@Test
	public void validarAcessoHomePage() throws InterruptedException {
		
		// configurando o relatorio
		ReportConfig config = new ReportConfig();
		config.setProjeto("Teste QA");
		config.setResponsavel("Sara Takata");
		config.setOutputDir(Utils.canonicalPath().concat("/evidencias/"));

		// chamando o gerador de relatorios
		ReportGenerator report = new ReportGenerator(config);
		Screenshot ss = new Screenshot(driver);

		report.setCasodeTeste(Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			screenRoll("//*[@id='post-4102']/div/div[1]/h2");
			report.addStep("Verificar carregamento da homepage.", ss.getScreenshot());
			assertTrue(telaHome.ultimasDoBlog()
					.contains("Últimas do Blog do Agi"));

			report.generator(Status.PASSED.toString());
		} catch (Exception e) {
			report.addStep("Evidencia de erro", ss.getScreenshot());
			report.generator(Status.FAILED.toString());
			assertTrue(false);
		}
	}
	
	@Test
	public void acessarArtigoUltimasDoBlog() throws InterruptedException {

		// configurando o relatorio
		ReportConfig config = new ReportConfig();
		config.setProjeto("Teste QA");
		config.setResponsavel("Sara Takata");
		config.setOutputDir(Utils.canonicalPath().concat("/evidencias/"));

		// chamando o gerador de relatorios
		ReportGenerator report = new ReportGenerator(config);
		Screenshot ss = new Screenshot(driver);

		report.setCasodeTeste(Thread.currentThread().getStackTrace()[1].getMethodName());
		try {

			String tituloArtigo = telaHome.getArtigosUltimasBlog();
			telaHome.acessar();
			telaUltimasBlog.waitTitle();
			report.addStep("Verificar 1º item 'Últimas do Blog Agi' está acessando.", ss.getScreenshot());
			assertTrue(telaUltimasBlog.getTitle()
					.contains(tituloArtigo));

			report.generator(Status.PASSED.toString());
		} catch (Exception e) {
			report.addStep("Evidencia de erro", ss.getScreenshot());
			report.generator(Status.FAILED.toString());
			assertTrue(false);
		}
	}

}
