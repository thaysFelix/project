package arvorebinaria;

public class Main {

    public static void main(String[] args) {
      
        BinarySearchTree no4 = new BinarySearchTree();
        no4.insert(4);
        no4.setChilds(null, null);
        
        BinarySearchTree no7 = new BinarySearchTree();
        no7.insert(7);
        no7.setChilds(null, null);
        
        BinarySearchTree no13 = new BinarySearchTree();
        no13.insert(13);
        no13.setChilds(null, null);

        BinarySearchTree no1 = new BinarySearchTree();
        no1.insert(1);
        no1.setChilds(null, null);
        
        BinarySearchTree no6 = new BinarySearchTree();
        no6.insert(6);
        no6.setChilds(no4, no7);
        
        BinarySearchTree no14 = new BinarySearchTree();
        no14.insert(14);
        no14.setChilds(no13,null);

        BinarySearchTree no3 = new BinarySearchTree();
        no3.insert(3);
        no3.setChilds(no1,no6);
        
        BinarySearchTree no10 = new BinarySearchTree();
        no10.insert(10);
        no10.setChilds(null,no14);

        BinarySearchTree root = new BinarySearchTree();
        root.insert(8);
        root.setChilds(no3, no10);

        //new BinarySearchTree().levelOrder(root);
        System.out.println(no7);
       
    }
    
}
