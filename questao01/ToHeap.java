package Trabalho;

public class ToHeap<T extends Comparable<T>> {

//    public static void main(String[] args) {;;
//        ToHeap<int> heap = new ToHeap<int>();
//        Integer[] vet = {40,87,2,90,1,100,30,20};
//        heap.toHeap(vet);
//
//        System.out.println("Depois: ");
//        for(int i = 0; i < vet.length; i++) {
//            System.out.println(vet[i]);
//        }
//    
//    }
    
    public ToHeap(){}

    public  void toHeap(T[] vet){
        int parent = (vet.length - 1)/2; 
        
        for (int i = parent; i > 0; --i) {
            child = ((parent + 1) * 2) - 1;
            if (vet[child] > vet[parent]) {
                    //swap(vet, parent, child);
                    up(vet,child);
            } else if (vet[child] < vet[parent]) {                   
                    down(vet,child);
            }
        }
    }

//    public <T extends Comparable<T>> void balancearHeap(int parent) {;
//        child = ((parent + 1) * 2) - 1;
//        
//        if(child)
//        if(vet[child + 1].compareTo(vet[parent]) == 1) {
//            
//        }
//
//        if(parent == 0)
//            return;
//        
//        
//        balancearHeap(parent - 1);
//    }

    private void up(T[] vet,int index) {

        int child = index;
        int p = (index - 1) / 2;

        if (child > 0) {
            if (vet[child] > vet[p]) {
                    swap(child, p);
                    up(p);
            }
        }
    }

    private void down(T[] vet,int index) {
        int p = index;
        int child = ((index + 1) * 2) - 1;
        if (child + 1 < size) {
                if (vet[child + 1] > vet[p]) {
                        swap(vet,p, child + 1);
                        down(child + 1);
                }
        } else if (child < size) {
                if (vet[child] > vet[p]) {
                        swap(vet,p, child);
                }
        }
    }

    private void swap(T vet, int i, int j) {
		int aux = vet[i];
		vet[i] = vet[j];
		vet[j] = aux;
    }
        
//    public <T extends Comparable<T>> void toHeap(T[] vet){
//        int parent = (vet.length - 1)/2; 
//        int child = ((parent + 1) * 2) - 1; 
//        T aux;
//            
//        System.out.println("Antes: ");
//        for(int i = 0; i < vet.length; i++) {
//            System.out.println(vet[i]);
//        }
//            
//        while (parent >= 0) {
//            child = ((parent + 1) * 2) - 1;
//                
//            //filho a direita
//            if(child + 1 < vet.length) { 
//                // se a > b
//                if (vet[child + 1].compareTo(vet[parent]) == 1) {
//                    aux = vet[parent];
//                    vet[parent] = vet[child+1];
//                    vet[child+1] = aux;
//                    
//                    if(vet[child].compareTo(vet[parent]) == 1) {
//                        aux = vet[parent];
//                        vet[parent] = vet[child];
//                        vet[child] = aux;
//                    }
//                                          
//                } else {
//
//                    if(vet[child].compareTo(vet[parent]) == 1) {
//                        aux = vet[parent];
//                        vet[parent] = vet[child];
//                        vet[child] = aux;
//                    }
//                    
//                }
//            //filho a esquerda
//            } else if (child < vet.length) {
//                //a > b
//                if (vet[child].compareTo(vet[parent]) == 1) {
//                    aux = vet[parent];
//                    vet[parent] = vet[child+1];
//                    vet[child+1] = aux;
//                            
//                }
//                
//                child = ((parent + 1) * 2) - 1;
//            }                
//            parent -- ;
//        }
//            
         
}
