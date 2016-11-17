public class Node 
{
  private int integer;
  private Node prevNode;
  private Node nextNode;

  Node(int i) 
  { 
    this.integer = i; 
    this.prevNode = null;
    this.nextNode = null;
  }
  
  public int getInteger()
  {
    return this.integer;
  }
  
  public Node getPrevNode()
  {
    return this.prevNode;
  }
  
  public Node getNextNode() 
  {
    return this.nextNode;
  }
  
  public void setInteger(int newInteger) 
  {
    this.integer = newInteger;
  }
  
  public void setPrevNode(Node newPrevNode) 
  {
    this.prevNode = newPrevNode;
  }
  
  public void setNextNode(Node newNextNode) 
  {
    this.nextNode = newNextNode;
  }
  
  public void print() 
  {
    System.out.print(integer + " " );
  }
}