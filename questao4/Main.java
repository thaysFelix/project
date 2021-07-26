package arvore;

public class Main {

    public static void main(String[] args) {
        
        BinarySearchTree arvore = new BinarySearchTree();

        arvore.insert(8);  
        arvore.insert(4);
        arvore.insert(12);
        arvore.insert(3);
        arvore.insert(6);
        arvore.insert(7);  
        arvore.insert(1);      
        arvore.insert(10);     
        arvore.insert(9);
        arvore.insert(11);       
        arvore.insert(13);
        
       //System.out.println(arvore.sucessor(arvore.root, 7)); // não funciona
       System.out.printf("Sucessor: %d\n",arvore.sucessor(arvore.root, 9)); //funciona
       
       //System.out.printf("Antecessor: %d\n",arvore.antecessor(arvore.root, 9));// nao funciona
       System.out.printf("Antecessor: %d\n",arvore.antecessor(arvore.root, 8)); // funciona

    }

}
