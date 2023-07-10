package application;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Caminho para ler o arquivo
        String strPath = "/home/matheus/vendas/source.csv";
        // Criando novo arquivo para escrever
        String path = "/home/matheus/vendas/out/summary.csv";

        try {
            // Leitura do arquivo source.csv
            BufferedReader br = new BufferedReader(new FileReader(strPath));
            //Escrever no arquivo summary.csv
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            
            //lêr cada linha do arquivo
            String line = br.readLine();
            String[] nome = new String[2];
            double[] preco = new double[1];
            int[] quantidade = new int[1];

            while (line != null) {
            	
                String[] values = line.split(",");

                nome[0] = values[0];
                preco[0] = Double.parseDouble(values[1]);
                quantidade[0] = Integer.parseInt(values[2]);

                for (int i = 0; i < preco.length; i++) {
                    for (int j = 0; j < quantidade.length; j++) {
                        String totalVendas = String.format("%.2f", preco[i] * quantidade[j]);
                        bw.write(nome[0] + "," + totalVendas);
                        bw.newLine();
                    }
                }

                line = br.readLine();
            }

            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }

}
