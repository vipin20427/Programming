public class permutationString{

  public static void main(String[] arg){
    String input = "abc";
    printPermutation(input.toCharArray(), 0);

  }

  public static void printPermutation(char[] inputs, int currentFocus){

    if (currentFocus == inputs.length - 1){
      System.out.println("New Permuation " + new String(inputs));
      return;
    }

    System.out.println("The currentFocus is " + currentFocus);
    printPermutation(inputs, currentFocus + 1);
    System.out.println("The currentFocus after the function call " + currentFocus);

    for (int i = currentFocus + 1 ; i < inputs.length; i++){
      char temp  = inputs[currentFocus];
      inputs[currentFocus] = inputs[i];
      inputs[i]  = temp;

      printPermutation(inputs, currentFocus + 1);
    }

  }


}
