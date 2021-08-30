package questao1;

public class Heap <T extends Comparable<T>> {
    
    public static void main(String[] args) {
        
        Heap heap = new Heap();
        Integer[] vet = {40,87,2,90,1,100,30,20,150,200,32,10}; 
        heap.toHeap(vet);
    
    }
    
    public Heap(){}
        
    //QUESTAO 1
    //Metodo que recebe um vetor de tipo qualquer e o organiza de acordo com a propriedade de heap
    public void toHeap(T[] vet){

        T[] elements = (T[]) new Comparable[vet.length];
        int size = 0;
        
        for(int i = 0; i < vet.length; i++) {
            if (size < elements.length) {
                elements[size] = vet[i];
                size += 1;
                up(elements,size - 1);
            
            }
        }
        
        System.out.println("MaxHeap... ");
        for(int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }
    }
    
    protected void up(T[] elements,int index) {

      int child = index;
      int p = (index - 1) / 2;

      if (child > 0) {
        if (elements[child].compareTo(elements[p]) > 0 ) {
                this.swap(elements,child, p);
                this.up(elements,p);
        }
      }
    }

    private void swap(T[] elements, int i, int j) {
        T aux = elements[i];
        elements[i] = elements[j];
        elements[j] = aux;		
    }
    
}