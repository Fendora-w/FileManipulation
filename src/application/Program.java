package application;

import entities.Sales;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		//caminho para lê o arquivo
		String pathStr = "/home/matheus/vendas/source.csv";
		//caminho para escrever no arquivo
		String path = "/home/matheus/vendas/out/summary.csv";
		
	    //passando o caminho como parametro
		Sales pathFile = new Sales(pathStr, path);
		pathFile.readerFile();//lê o arquivo
		pathFile.writerFile();//grava o arquivo
			
		   
			
	
		
		
	}

}
