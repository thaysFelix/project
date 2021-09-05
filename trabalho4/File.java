package trabalho4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class File {
    
    public static void leitor(String path) throws IOException {       
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
	String linha = "";
        
        while (true) {
            if (linha != null) {
                //System.out.println(linha);

            } else
                break;
            linha = buffRead.readLine();           
	}
	buffRead.close();
    }
    
    public static void escrever(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path,true));
        String linha = "";
        
        Scanner in = new Scanner(System.in);
        System.out.println("Escreva algo: ");
	linha = in.nextLine();
	buffWrite.append(linha + "\n");
        
	buffWrite.close();
    }
//    public static void main(String[] args) throws IOException {
//        String path = "C:\\Users\\Thays&Thalys\\Documents\\NetBeansProjects\\Trabalho4\\src\\trabalho4\\qualquercoisa.txt";
//
//        //File.escrever(path);
//        File.leitor(path);
//	
//    }
    
}
