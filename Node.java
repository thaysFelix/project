package questao02;

public class Node {
    
    private int valor;
    private Node esquerdo;
    private Node direito;
    
    Node(int valor, Node esquerdo, Node direito) {
        this.valor = valor;
        this.esquerdo = esquerdo;
        this.direito = direito;
    }
    
    public void imprimir(Node n) {
        System.out.println(n.valor);
        if(n.esquerdo != null){
            imprimir(n.esquerdo);
        }
        
        if(n.direito != null) {
            imprimir(n.direito);
        }
    }
}
