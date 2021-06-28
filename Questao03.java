package classes;
import java.util.ArrayList;
import java.util.Scanner; 

public class Questao03 {
    
    public double mediaRecursiva(ArrayList<Double> valor, int tamanho, int i ) {

        if (i == tamanho - 1){
            return valor.get(i);
        } 

        if(i == 0){
            return (valor.get(i) + mediaRecursiva(valor, tamanho, i+1)) / valor.size();

        }else {
            return valor.get(i) + mediaRecursiva(valor, tamanho, i + 1);
        }

    }
     
    public static void main(String[] args) {
        Scanner ler;
        
        ArrayList<Double> valor = new ArrayList();
        
        double media;
        double numero;
        char controle;
        int i;
        
        while(true) { 
            ler = new Scanner(System.in);
            System.out.println("Digite um numero:");
            numero = Double.parseDouble(ler.nextLine());
            valor.add(numero);
            System.out.println("Deseja inserir outro numero? (s - sim; n - nao)");
            controle = ler.next().toLowerCase().charAt(0);
            
            if(controle == 'n'){
                System.out.println("... Calculando");
                break;
            }
        } 
        Questao03 q3 = new Questao03();
        media = q3.mediaRecursiva(valor, valor.size(), i = 0);
        System.out.printf("A media e: %.2f\n", media ); 

    }
    
}
