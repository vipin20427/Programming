import java.util.Scanner;
/* Also finds the Kth Largest element.
*/
public class QuickSort{
  int array[];
  int kThLargest;
  int k;

  public QuickSort(int array[], int k){
    this.array = array;
    this.k = k;
  }

  public void quickSort(){
    int left = 0;
    int right = array.length - 1;
    quickSortUtil(left,right);
  }


  private void swap(int position1, int position2){
    int temp = array[position1];
    array[position1] = array[position2];
    array[position2] = temp;
  }

  private int partition(int left , int right){
    int pivot = array[right];
    int i = left;

    for (int j = left; j <= (right - 1); j++){
        if (array[j] <= pivot){
          swap(i,j);
          i++;
        }
    }
    swap(i,right);

    if (k == i){
      kThLargest = array[i];
    }

    return i;
  }

  private void quickSortUtil(int left, int right){
    if (left < right){
      int partitionIndex = partition(left,right);
      quickSortUtil(left, partitionIndex - 1);
      quickSortUtil(partitionIndex + 1, right);
    }
  }

  public String toString(){
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < array.length; i++){
        stringBuilder.append(array[i] +" ");
    }
    stringBuilder.append("\n The Kth Largest Element is " + kThLargest);
    return stringBuilder.toString();
  }


  public static void main(String[] arg){
    Scanner scanner = new Scanner(System.in);
    int numberOfElements = scanner.nextInt();

    int array[] = new int[numberOfElements];
    for (int i = 0; i < numberOfElements; i++){
      array[i] = scanner.nextInt();
    }

    QuickSort quickSort = new QuickSort(array, 4);
    quickSort.quickSort();
    System.out.println(quickSort);
  }

}
