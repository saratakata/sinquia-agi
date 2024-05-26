package br.com.agi.teste_qa.utils;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Utils {

	/**
	 * Funcao simplificada que retorna a data atual.
	 * @return 
	 */
	public static String getDate()
	{
		Date data = new Date(System.currentTimeMillis());  
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy"); 
		return formatarDate.format(data);
	}
	
	
	/**
	 * Funcao simplificada que retorna a data atual.
	 * @return 
	 */
	public static String getDateTime()
	{
		Date data = new Date(System.currentTimeMillis());  
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		return formatarDate.format(data);
	}
	
	
	/**
	 * Retorna o diretorio da aplicacao.
	 * 
	 * @return
	 */
	public static String canonicalPath()
	{
		String ret = "";
		try {
			ret = new File(".").getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * Cria o nome do arquivo de output automaticamente.
	 * 
	 * @param path
	 * @param ctName
	 * @return
	 */
	public static String createFileName(String path, String ctName)
	{		
		Date data = new Date(System.currentTimeMillis());  
		SimpleDateFormat formatarDate = new SimpleDateFormat("YYYYMMddHHmmss"); 
		String dt = formatarDate.format(data);
			
		if(path!=null && ctName != null && !path.equals("") && !ctName.equals("")){
			String str = ctName.concat("-").concat(dt).replaceAll(" ", "_");
			return path.concat(str).concat(".pdf");
		}else{
			return canonicalPath().concat("/report.pdf");
		}
	}
	

}
