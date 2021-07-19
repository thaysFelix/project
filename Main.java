package arvore;

public class Main {

    public static void main(String[] args) {
    
        BinarySearchTree arvore = new BinarySearchTree();
        Node no = new Node(8);
        arvore.setRoot(no);
        arvore.insert(no, 2);
    }
    
}
