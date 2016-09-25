public class PalindromeList{

  Node left;

  public boolean isPalindrome(List list){
    Node right = list.root;
    left = list.root;

    return palindromeUtil(right);

  }


  private  boolean palindromeUtil( Node right){

    if (right == null){
      return true;
    }

    if (!palindromeUtil(right.next))
     return false;

    if (left.character == right.character)
    {
         left = left.next;
        return true;
    }else
    {
      return false;
    }
  }


  public static void main(String[] arh){
    List list1 = new List();

    list1.insert('a');
    list1.insert('l');
    list1.insert('o');
    list1.insert('a');

    PalindromeList palindrome = new PalindromeList();
    System.out.println(palindrome.isPalindrome(list1));

  }
}

class Node{
  char character;
  Node next;

  Node (){
    next = null;
  }
}

class List{
  Node root;


  public void insert(char character){

      if (root == null){
        Node temp = new Node();
        temp.character = character;
        root = temp;
        return ;
      }

      Node traverse = root;
      while(traverse.next != null){
        traverse = traverse.next;
      }

      Node temp = new Node();
      temp.character = character;
      traverse.next = temp;
      return;
  }

  public String toString(){
    StringBuilder stringBuilder = new StringBuilder();
    for (Node traverse = root; traverse != null; traverse= traverse.next)
      stringBuilder.append(traverse.character);

    return stringBuilder.toString();
  }


}
