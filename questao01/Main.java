package trabalho;

public class Main {

    public static void main(String[] args) {

      Heap<Integer> heap = new Heap<Integer>();
      Integer[] vet = {40,87,2,90,1,100,30,20, 150, 200, 30, 10};
      heap.toHeap(vet);

      System.out.println("Depois: ");
      for(int i = 0; i < vet.length; i++) {
         System.out.println(vet[i]);
     }

  }

}
