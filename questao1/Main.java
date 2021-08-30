
public class Main {
	public static void main(String[] args) {
        
        Heap heap = new Heap();
        Integer[] vet = {40,87,2,90,1,100,30,20,150,200,32,10};
        
        heap.toHeap(vet);
        Heap.MeuComparador comparador = new Heap.MeuComparador();
        heap.toHeap(vet, comparador);
        
    }
}
