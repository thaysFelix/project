package trabalho3;

public class ToHeap {
    public static void main(String[] args) {
        ToHeap heap = new ToHeap();
        Integer[] vet = {40,87,2,90,1,100,30,20};
        heap.toHeap(vet);
    
    }
    
    public ToHeap(){}
        
    public <T extends Comparable<T>> void toHeap(T[] vet){
        int parent = (vet.length - 1)/2;
        int child = ((parent + 1) * 2) - 1;
        T aux;
            
        System.out.println("Antes: ");
        for(int i = 0; i < vet.length; i++) {
            System.out.println(vet[i]);
        }
            
        while (parent >= 0) {
            // child = ((parent + 1) * 2) - 1;
                
            //filho a direita
            if(child + 1 < vet.length) { 
                // se a > b
                if (vet[child + 1].compareTo(vet[parent]) == 1) {
                    aux = vet[parent];
                    vet[parent] = vet[child+1];
                    vet[child+1] = aux;
                        
                } else {
                    parent --;
                    child = ((parent + 1) * 2) - 1;
                }
            //filho a esquerda
            } else if (child < vet.length) {
                //a > b
                if (vet[child].compareTo(vet[parent]) == 1) {
                    aux = vet[parent];
                    vet[parent] = vet[child+1];
                    vet[child+1] = aux;
                            
                }
                parent -- ;
                child = ((parent + 1) * 2) - 1;
            }                
               
        }
            
        System.out.println("Depois: ");
        for(int i = 0; i < vet.length; i++) {
            System.out.println(vet[i]);
        } 
    }
}
