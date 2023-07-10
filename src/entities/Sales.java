package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Sales {
	
	private String pathStr;
	private String path;
	private String nome;
	private Double preco;
	private Integer quantidade;
	
	ArrayList<Sales> list = new ArrayList<>();
	
	public Sales(String nome, Double preco, Integer quantidade) {

		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}


	public Sales(String pathStr, String path) {
		this.pathStr = pathStr;
		this.path = path;
	}
	
	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}



	public void readerFile()  { //lê o arquivo
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(pathStr));
			
			String line = br.readLine();
			//ler cada linha do arquivo
			while(line != null) {
				String[] values = line.split(",");
				String nome = values[0];
				double preco = Double.parseDouble(values[1]);
				int quantidade = Integer.parseInt(values[2]); 
			    list.add(new Sales(nome, preco, quantidade));
			
				
				line = br.readLine();
			}

			br.close();
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	
	}
	
	
	public void writerFile() { //gavar o arquivo 
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			
			for(Sales l : list) {
				String totalVendas = String.format("%.2f", l.getPreco()*l.getQuantidade());
				bw.write(l.getNome()+", "+totalVendas);
				bw.newLine();
			}
			
			bw.close();
            
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
		
	
}
