package arvore;

import java.util.LinkedList;

public class BinarySearchTree extends Node implements Tree {

    public BinarySearchTree(int value) {
        super(value);
    }

    public Node root;

    BinarySearchTree() {
 
    }

    protected void setRoot(Node root) {
        this.root = root;
    }

    @Override
    public boolean insert(int value) {
        if (root == null) {
            root = new Node(value);
            return true;
        } else {
            return this.insert(root, value);
        }
    }

    public void printFilho(Node no) {

        no.toString();

        if (!no.isLeaf()) {
            if (no.hasLeft()) {
                printFilho(no.left);
            }

            if (no.hasRight()) {
                printFilho(no.right);
            }

        }
    }

    private boolean insert(Node node, int value) {
        if (value > node.value) {
            if (node.hasRight()) {
                return this.insert(node.right, value);
            } else {
                Node newnode = new Node(value);

                newnode.parent = node;

                node.right = new Node(value);

            }
        } else if (value < node.value) {
            if (node.hasLeft()) {

                return this.insert(node.left, value);
            } else {
                node.left = new Node(value);
            }
        } else {
            return false; // contains value
        }
        return true;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {
        if (node == null) {
            return false;
        } else {
            if (node.value == value) {
                return true;
            } else if (value > node.value) {
                return contains(node.right, value);
            } else if (value < node.value) {
                return contains(node.left, value);
            }
        }
        return false;
    }

    public boolean remove(int value) {
        root = remove(root, value);
        return true;
    }

    private Node remove(Node node, int value) {
        if (node == null) {
            return null;
        } else if (node.value == value) {
            if (node.isLeaf()) {
                return null;
            } else if (node.hasLeft() && !node.hasRight()) {
                return node.left;
            } else if (node.hasRight() && !node.hasLeft()) {
                return node.right;
            } else {
                Node child = node.right;
                if (!child.hasLeft()) {
                    child.left = node.left;
                    return child;
                } else {
                    Node successor = removeSuccessor(child);
                    successor.left = node.left;
                    successor.right = node.right;
                    return successor;
                }
            }
        } else if (value > node.value) {
            node.right = remove(node.right, value);
            return node;
        } else if (value < node.value) {
            node.left = remove(node.left, value);
            return node;
        }
        return node;
    }

    protected Node removeSuccessor(Node node) {
        if (!node.left.hasLeft()) {
            Node successor = node.left;
            node.left = successor.right;
            return successor;
        } else {
            return removeSuccessor(node.left);
        }
    }

    public int height() {
        return height(root, 0);
    }

    private int height(Node node, int level) {
        if (node == null) { // root
            return level;
        }
        return Math.max(height(node.left, level + 1), height(node.right, level + 1));
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.print(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root);
            inOrder(root.right);
        }
    }

    public void posOrder() {
        posOrder(root);
    }

    private void posOrder(Node root) {
        if (root != null) {
            posOrder(root.left);
            posOrder(root.right);
            System.out.print(root);
        }
    }

    public void levelOrder(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node current = queue.removeFirst();
            if (current != null) {
                System.out.println(current);
                queue.addLast(current.left);
                queue.addLast(current.right);
            }
        }
    }

    public String toString() {
        return toString(root, "", 0);
    }

    public String toString(Node current, String tabs, int level) {
        if (current == null) {
            return "";
        }
        String str = toString(current.right, tabs + "\t", level + 1);
        str += String.format("%s%s [Level:%d]\n", tabs, current, level + 1);
        str += toString(current.left, tabs + "\t", level + 1);
        return str;
    }

    private boolean equals(Node aNode, Node bNode) {
        if (aNode != null && bNode != null) {
            boolean left = equals(aNode.left, bNode.left);
            boolean right = equals(aNode.right, bNode.right);
            return aNode.value == bNode.value && left && right;
        } else {
            return aNode == null && bNode == null;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof BinarySearchTree) {
            BinarySearchTree tree = (BinarySearchTree) obj;
            return equals(root, tree.root);
        } else {
            return super.equals(obj);
        }
    }
    
    public Node buscar(Node node, int value) {
        if (node == null) {
            return node;
        } else {
            if (node.value == value) {
                return node;
            } else if (value > node.value) {
                return buscar(node.right, value);
            } else if (value < node.value) {
                return buscar(node.left, value);
            }
        }
        return node;
    }

    public int sucessor(Node node, int valorX) {
        Node noValorX = buscar(node, valorX);
            
        
        if(noValorX.right == null){
            return sucessorFolha(node, valorX);
        }
        
        Node inicioBuscaSucessor = noValorX.right;
        
        
        while(inicioBuscaSucessor.hasLeft() ) {
            inicioBuscaSucessor = inicioBuscaSucessor.left;
        }
        
        return inicioBuscaSucessor.value;
    }
    
    public int sucessorFolha(Node node, int valorX) {
        int maior;
        
        if(root.value < valorX){
            Node inicioBuscaSucessor = root.right;
            maior = root.value;
            while(inicioBuscaSucessor.hasLeft()) {
                if(inicioBuscaSucessor.left.value == valorX){
                    return inicioBuscaSucessor.value; 
                }
                
                inicioBuscaSucessor = inicioBuscaSucessor.left;
            }
            
            return valorX;
        }
        else if(root.value > valorX){
            Node inicioBuscaSucessor = root.left;
            while(inicioBuscaSucessor.hasRight()) {
                if(inicioBuscaSucessor.right.value == valorX){
                    return inicioBuscaSucessor.value; 
                }
                
                inicioBuscaSucessor = inicioBuscaSucessor.right;
            }
            
            return valorX;
        }else{ // se valorX for a raiz
            return valorX;
        }
    }
    
    public int antecessor(Node node, int valorX) {
        Node noValorX = buscar(node, valorX);
                  
        if(noValorX.left == null){
            return antecessorFolha(node, valorX);
        }
        
        Node inicioBuscaAntecessor = noValorX.left;
        
        
        while(inicioBuscaAntecessor.hasRight() ) {
            inicioBuscaAntecessor = inicioBuscaAntecessor.right;
        }
        
        return inicioBuscaAntecessor.value;
    }
    
    public int antecessorFolha(Node node, int valorX) {
        int menor;
        
        if(root.value > valorX){
            Node inicioBuscaAntecessor = root.left;
            menor = root.value;
            while(inicioBuscaAntecessor.hasRight()) {
                if(inicioBuscaAntecessor.right.value == valorX){
                    return inicioBuscaAntecessor.value; 
                }
                
                inicioBuscaAntecessor = inicioBuscaAntecessor.right;
            }
            
            return valorX;
        }
        else if(root.value < valorX){
            Node inicioBuscaAntecessor = root.right;
            while(inicioBuscaAntecessor.hasLeft()) {
                if(inicioBuscaAntecessor.left.value == valorX){
                    return inicioBuscaAntecessor.value; 
                }
                
                inicioBuscaAntecessor = inicioBuscaAntecessor.left;
            }      
            return valorX;
        }else{ // se valorX for a raiz
            return valorX;
        }
    }
        /*Quest�o 3*/
//   // private int countNodes(Node root) {
//
//        if (root == null) {
//            return 0;
//        }
//
//        return (1 + countNodes(root.left) + countNodes(root.right));
//    }
//
//    public int countNodes() {
//        return countNodes(root);
//    }
//
//    private boolean isComplete(Node root, int index, int nNodes) {
//
//        if (root == null) {
//            return true;
//        }
//
//        if (index >= nNodes) {;
//            return false;
//        }
//
//        return (isComplete(root.left, 2 * index + 1, nNodes)
//                && isComplete(root.right, 2 * index + 2, nNodes));
//    }
//
//    public boolean isComplete() {
//        return isComplete(root, 0, countNodes());
//    }
//
//    /*Fim da quest�o 3. Testes na main */
}
