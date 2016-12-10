public class Node 
{
  String word;
  int count;
  Node parentNode;
  Node leftNode;
  Node rightNode;

  Node(String word) 
  { 
    this.word = word; 
    this.count = 1;
    this.parentNode = null;
    this.leftNode = null;
    this.rightNode = null;
  }
  
  public void print() 
  {
    System.out.println(word + " count: " + this.count);
  }
}
