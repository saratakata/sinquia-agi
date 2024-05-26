package br.com.agi.teste_qa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ImageRead {

	/**
	 * Converte em bytes a imagem de entrada
	 * 
	 * @param image caminho completo da imagem
	 * @return bytes da imagem
	 * @throws IOException
	 */
	public static byte[] imageToByte(String image) throws IOException {
	    InputStream is = null;
	    byte[] buffer = null;
	    is = new FileInputStream(image);
	    buffer = new byte[is.available()];
	    is.read(buffer);
	    is.close();
	    return buffer;
	}
	
	/**
	 * Converte a image para FileInputStream
	 * 
	 * @param image caminho completo da imagem
	 * @return FileInputStream
	 * @throws IOException
	 */
	public static FileInputStream imageToInputStream(String image) {
	    try {
			return new FileInputStream(image);
		} catch (FileNotFoundException e) {
			System.out.println("File not found:"+image);
			return null;
		}
	}
}
