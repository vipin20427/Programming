import java.util.Scanner;
public class Rectangle{

  int top, right,bottom,left;
  boolean isTopFound = false ,isLeftFound = false ,isRightFound = false,isBottomFound = false;
  int topRow, bottomRow;


  private void findRectangle(int [][] matrix){

    findTopAndRightCoordinate(matrix);
    findLeftAndBottomCoordinate(matrix);
  }

  public String toString(){
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Top: (" +topRow +"," + top +") \n" );
      stringBuilder.append("Right: (" +topRow +"," + right +") \n" );
      stringBuilder.append("Left: (" +bottomRow +"," + left +") \n" );
      stringBuilder.append("Bottom: (" +bottomRow +"," + bottom +") \n" );

      return stringBuilder.toString();
  }

  private void findLeftAndBottomCoordinate(int [][] matrix){
    int length = matrix.length -1 ;

    for (int row = length; row >= topRow; row--){

      if (!isBottomFound){
          for (bottom = length; bottom > 0; bottom--){
            if (matrix[row][bottom] == 0){
               isBottomFound = true;
               bottomRow = row;
               break;
             }
          }
      }

      if (!isLeftFound){
          for (left = 0; left < length; left++){
            if (matrix[row][left] == 0){
               isLeftFound = true;
               break;
             }
          }
      }
    }
  }


  private void findTopAndRightCoordinate(int [][] matrix){

    int length = matrix.length - 1 ;

    for (int row = 0; row <= length; row++){

      if (!isTopFound){
          for (top = 0; top <= length; top++){
            if (matrix[row][top] == 0){
               isTopFound = true;
               topRow = row;
               break;
          }
        }
      }

      if (!isRightFound){
          for (right = length; right > 0; right--){
            if (matrix[row][right] == 0){
               isRightFound = true;
               break;
             }
          }
      }
    }
  }

  public static void main(String[] arg){

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int array[][]= new int [n][n];

    for (int i =0; i < n;i++){
      for (int j =0; j< n; j++){
        array[i][j] = scanner.nextInt();
      }
    }

    System.out.println("The array elements are ");
    for (int i =0; i < n;i++){
      for (int j =0; j< n; j++){
        System.out.print(array[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();

    Rectangle rectangle = new Rectangle();
    rectangle.findRectangle(array);
    System.out.println(rectangle);

  }


}
