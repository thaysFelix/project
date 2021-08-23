package trabalho3;

public class Heap {

	public static void main(String[] args) {
		Heap heap = new Heap();
                Integer[] vet = {40,87,2,90,1,100,30,20};
                heap.toHeap(vet);
                
                   
		/*heap.insert(0);
		heap.insert(9);
		heap.insert(5);
		heap.insert(3);
		heap.insert(2);
		heap.insert(7);
                heap.insert(6);
                heap.insert(1);
                heap.insert(4);
                heap.insert(11); */
                //heap.insert(10);
                //heap.insert(8);
               
		//while(heap.size() > 0) {
			//System.out.println("GET " + heap.get());
			//System.out.println("REMOVE " + heap.remove());
		//}
                
	}

	protected int[] elements;
	protected int size;

	/*public Heap(int capacity) {
		size = 0;
		elements = new int[capacity];
	} */
        public Heap(){}
        
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
    
	public void up(int index) {
		int child = index;
		int p = (index - 1) / 2;
		if (child > 0) {
			if (elements[child] > elements[p]) {
				swap(child, p);
				up(p);
			}
		}
	}
        
	private void down(int index) {
		int p = index;
		int child = ((index + 1) * 2) - 1;
		if (child + 1 < size) {
			if (elements[child + 1] > elements[p]) {
				swap(p, child + 1);
				down(child + 1);
			}
		} else if (child < size) {
			if (elements[child] > elements[p]) {
				swap(p, child);
			}
		}
	}

	public void swap(int i, int j) {
		int aux = elements[i];
		elements[i] = elements[j];
		elements[j] = aux;
	}

	public void update(int current, int newValue) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (elements[i] == current) {
				index = i;
			}
		}
		if (index != -1) {
			if (newValue > current) {
				current = newValue;
				up(index);
			} else if (newValue < current) {
				current = newValue;
				down(index);
			}
		}
	}

	public boolean insert(int e) {
            
		if (size < elements.length) {
			elements[size] = e;
			size += 1;
			up(size - 1);
			return true;
		}
                // aqui vai a exceção de overflow
                System.out.println("Capacidade excedida");
		return false;
	}

	public int remove() {
            //aqui vai a exceção de underflow
		int value = elements[0];
		elements[0] = elements[size - 1];
		size--;
		down(0);
		return value;
	}

	public int getIndex(int index) {
            
		return elements[index];
	}

	public int size() {
		return size;
	}
}
