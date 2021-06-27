
package primeiroprograma;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimeiroPrograma {
    
    public static String calculaMedia(ArrayList<String> valor) {
        double soma = 0;
        double media;
        
        for(int i = 0; i < valor.size(); i++) {
            soma = Integer.parseInt(valor.get(i)) + soma;
        }
        
        media = soma / valor.size(); 
            
        return String.valueOf(media);
    }
    
    public static String calculaDesvio(ArrayList<String> valor, String media) {
        double desvio; 
        double aux = 0;
        double aux2 = 0;
        double variancia = 0;
        
        for(String n : valor) {
            aux = Double.parseDouble(n) - Double.parseDouble(media);
            aux2 = (aux*aux) + aux2;
            variancia = aux2/valor.size();
        }
        
        desvio = Math.sqrt(variancia);
        
        return String.valueOf(desvio);
    }

    public static void main(String[] args) {
        Scanner ler;
        
        ArrayList<String> valor = new ArrayList();
        
        String numero;
        char controle;
        String media;
        String desvio;
        
        while(true) { 
            ler = new Scanner(System.in);
            System.out.println("Digite um numero:");
            numero = ler.nextLine();
            valor.add(numero);
            System.out.println("Deseja inserir outro numero? (s - sim; n - nao)");
            controle = ler.next().toLowerCase().charAt(0);
            
            if(controle == 'n'){
                System.out.println("... Calculando");
                break;
            }
        } 
        media = PrimeiroPrograma.calculaMedia(valor);
        desvio = PrimeiroPrograma.calculaDesvio(valor,media);
        
        System.out.println("A media e: " + media); 
        System.out.println("O desvio padrao e: " + desvio); 

        for(int i = 0; i < valor.size(); i++) {
            System.out.print(valor.get(i) + " ");
        }
        
         
    }
    
}
