package questao02;
import java.util.Scanner;


public class Questao09 {
    
    public static void main(String[] args){
        Scanner ler;
        
        Node no = new Node(15, new Node(10, null, null), new Node(50, new Node(20, null, null), null));
        no.imprimir(no);
    }
}
