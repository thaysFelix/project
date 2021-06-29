package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Questao04 {
    
     public double calcula(ArrayList<Double> numeros, int tamanho) {
         
         double resultado;
         
         return resultado;
     }

    public static void main(String[] args) {
        Scanner ler;
        
        ArrayList<Double> numeros = new ArrayList();
        
        double numero;
        int n;
        char controle;
        double resposta;
        
        while(true) { 
            ler = new Scanner(System.in);
            System.out.println("Digite um numero:");
            numero = Double.parseDouble(ler.nextLine());
            numeros.add(numero);
            System.out.println("Deseja inserir outro numero? (s - sim; n - nao)");
            controle = ler.next().toLowerCase().charAt(0);
            
            if(controle == 'n'){
                System.out.println("... Calculando");
                break;
            }
        } 
        n = numeros.size();
        
        Questao04 q4 = new Questao04();
        resposta = q4.calcula(numeros, n);

    }
}
