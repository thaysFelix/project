package questao02;
import java.util.ArrayList;
import java.util.Scanner; 

public class Questao02 {
    
    public static String mediaRecursiva(ArrayList<String> valor) {
 
        double media = 0;
        double divisao;
        
        for(int i = 0; i < valor.size(); i++) {
            if (i == valor.size()- 1) {
                return valor.get(i);
            } 
            if (i == 0) {
                divisao = (Double.parseDouble(valor.get(i)) + Double.parseDouble(mediaRecursiva(valor)) ) / valor.size();
                return String.valueOf(divisao);
            }
            media = Double.parseDouble(valor.get(i)) + Double.parseDouble(mediaRecursiva(valor));    
            return String.valueOf(media); 
        }
        return "fim";
    }
     
    public static void main(String[] args) {
        Scanner ler;
        
        ArrayList<String> valor = new ArrayList();
        
        String media;
        String numero;
        char controle;
        
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
        media = Questao02.mediaRecursiva(valor);
        System.out.println("A media e: " + media); 

        for(int i = 0; i < valor.size(); i++) {
            System.out.print(valor.get(i) + " ");
        }
    }
    
}
