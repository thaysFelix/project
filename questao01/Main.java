package Trabalho;

public class Main {

    public static void main(String[] args) {

      ToHeap<int> heap = new ToHeap<int>();
      Integer[] vet = {40,87,2,90,1,100,30,20};
      heap.toHeap(vet);

      System.out.println("Depois: ");
      for(int i = 0; i < vet.length; i++) {
          System.out.println(vet[i]);
      }

  }
}
