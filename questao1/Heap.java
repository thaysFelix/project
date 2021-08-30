import java.util.Comparator;

public class Heap <T extends Comparable<T>> {
    
	public static class MeuComparador<T extends Comparable<T>> implements Comparator<T>{
	    @Override
	    public int compare(T k1, T k2) {
	        return k1.compareTo(k2);
	    }
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
                up(elements,size - 1, null);
            
            }
        }
        
        System.out.println("MaxHeap (sem Comparator)... ");
        for(int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }
    }
    
    protected void up(T[] elements,int index, Comparator<T> comparator) {

      int child = index;
      int p = (index - 1) / 2;

      if (child > 0) {
    	  int comparacao = (comparator != null) ? comparator.compare( elements[child], elements[p]) : elements[child].compareTo(elements[p]);
        if (comparacao > 0 ) {
                this.swap(elements,child, p);
                this.up(elements,p, comparator);
        }
      }
    }

    private void swap(T[] elements, int i, int j) {
        T aux = elements[i];
        elements[i] = elements[j];
        elements[j] = aux;		
    }
    
    
    
    public void toHeap(T[] vet,  Comparator<T> comparator){
            T[] elements = (T[]) new Comparable[vet.length];
            int size = 0;
            
            for(int i = 0; i < vet.length; i++) {
                if (size < elements.length) {
                    elements[size] = vet[i];
                    size += 1;
                    up(elements,size - 1, comparator);
                
                }
            }
            
            System.out.println("MaxHeap (Com Comparator)... ");
            for(int i = 0; i < elements.length; i++) {
                System.out.println(elements[i]);
            }
        }
    
}