package questao3;

public class Heap <T extends Comparable<T>>  {

    public static void main(String[] args) {

        Heap heap = new Heap(16);
        heap.insert(40);
        heap.insert(87);
        heap.insert(2);
        heap.insert(90);
        heap.insert(1);
        heap.insert(100);
        heap.insert(30);
        heap.insert(20);
        heap.insert(150);
        heap.insert(200);
        heap.insert(30);
        heap.insert(10);

        while(heap.size() > 0) {
                System.out.println("GET " + heap.get());
                System.out.println("REMOVE " + heap.remove());
        }
    }

    protected T[] elements;
    protected int size;

    public Heap(int capacity) {
        size = 0;
        elements  = (T[]) new Comparable[capacity];
    }

    private void up(int index) {
        int child = index;
        int p = (index - 1) / 2;
        
        if (child > 0) {
            if (elements[child].compareTo(elements[p]) > 0) {
                swap(child, p);
                up(p);
            }
        }
    }

    private void down(int index) {
        int p = index;
        int child = ((index + 1) * 2) - 1;
        
        if (child + 1 < size) {
            if (elements[child + 1].compareTo(elements[p]) > 0) {
                swap(p, child + 1);
                down(child + 1);
            }
        } else if (child < size) {
            if (elements[child].compareTo(elements[p]) > 0) {
                swap(p, child);
            }
        }
    }

    private void swap(int i, int j) {
        T aux = elements[i];
        elements[i] = elements[j];
        elements[j] = aux;
    }

    public void update(T current, T newValue) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].compareTo(current) == 0) {
                index = i;
            }
        }
        if (index != -1) {
            if (newValue.compareTo(current) > 0) {
                current = newValue;
                up(index);
            } else if (newValue.compareTo(current) < 0) {
                current = newValue;
                down(index);
            }
        }
    }

    public boolean insert(T e) {
        if (size < elements.length) {
            elements[size] = e;
            size += 1;
            up(size - 1);
            return true;
        }
        return false;
    }

    public T remove() {
        T value = elements[0];
        elements[0] = elements[size - 1];
        size--;
        down(0);
        return value;
    }

    public T get() {
        return elements[0];
    }

    public int size() {
            return size;
    }
    
}
  

