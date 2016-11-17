public class IntegerList
{
  Node first;
  Node last;
  int maxInteger;

  IntegerList() 
  { 
    this.first = null;
    this.last = null;
    this.maxInteger = 200;
  }
  
  public Node getFirst() 
  {
    return this.first;
  }
  
  public Node getLast() 
  {
    return this.last;
  }
  
  public void setFirst(Node newFirst) 
  {
    if (this.first == this.last)
    {
      this.last = newFirst;
      this.first = newFirst;
    }
  }
  
  public void setLast(Node newLast) 
  {
    if (this.first == this.last)
    {
      this.first = newLast;
      this.last = newLast;
    }
  }
  
  public int getMaxInteger() 
  {
    return this.maxInteger;
  }
  
  public void setMaxInteger(int newMaxInteger) 
  {
    this.maxInteger = newMaxInteger;
  }
  
  public void random(int length) 
  {
    for (int i = 0; i < length; i++) 
    {
      Node newNode = new Node((int) 
                                (Math.random() * this.maxInteger));
      if (isEmpty()) 
      {
        this.first = newNode;
        this.last = newNode;
      }
      else 
      {
        newNode.setNextNode(first);
        first.setPrevNode(newNode);
        this.first = newNode;
      }
    }
  }
  
  public void addInteger(int newInteger) 
  {
    Node newNode = new Node(newInteger);
    
    if (this.isEmpty()) 
    {
      this.first = newNode;
      this.last = newNode;
    }
    else 
    {
      Node current = this.first;
      
      while(current != null) 
      {
        if (current != null && newNode.getInteger() < current.getInteger()) 
        {
          newNode.setNextNode(this.first);
          this.first = newNode;
          current.setPrevNode(newNode);
          break;
        }
        else if (newNode.getInteger() < current.getNextNode().getInteger()) 
        {
          newNode.setNextNode(current.getNextNode());
          current.getNextNode().setPrevNode(newNode);
          current.setNextNode(newNode);
          newNode.setPrevNode(current);
          break;
        }
        else if (current.getNextNode() == null) 
        {
          current.setNextNode(newNode);
          newNode.setPrevNode(current);
          this.last = newNode;
          break;
        }
        current = current.getNextNode();
      }
    }
  }
  
  public boolean isEmpty() 
  {
    return this.first == null;
  }
  
  public boolean deleteNode(int integer) 
  {
    Node current = this.first;
    while(current != null) 
    {
      if (current.getNextNode() != null && current.getNextNode().getInteger() == integer) 
      {
        current.setNextNode(current.getNextNode().getNextNode());
        current.getNextNode().setPrevNode(current);
        return(true);
      }
      current = current.getNextNode();
    }
    return(false);
  }
  
  public void deleteList() 
  {
    this.first = null;
    this.last = null;
  }
  
  public void print() 
  {
    Node current = this.first;
    while(current != null) 
    {
      current.print();
      current = current.getNextNode();
    }
    System.out.println("");
  }
  
  public void printReverse() 
  {
    Node current = this.last;
    
    while(current != null) 
    {
      current.print();
      current = current.getPrevNode();
    }
    System.out.println("");
  }
  
  public void sort() 
  {
    this.first = this.sort(this.first, this.maxInteger);
    Node current = this.first;
    while (current.getNextNode() != null) 
    {
      current = current.getNextNode();
    }
    this.last = current; 
  }
  
  public Node sort(Node listFirst, int lastValue) 
  {
    if ((listFirst.getNextNode() == null) || (listFirst.getNextNode().getInteger() >= lastValue)) 
    {
      return (listFirst);
    }
    else 
    {
      Node low = null;
      Node high = null;
      Node tmp = null;
      Node current = first;
      while (current != null) 
      {
        tmp = current;
        current = current.getNextNode();
        if (tmp.getInteger() < lastValue/2) 
        {
          if (low == null)
          {
            low = tmp;
          }
          else 
          {
            tmp.setNextNode(low);
            low.setPrevNode(tmp);
            low = tmp;
          }
        } 
        else 
        {
          if (high == null)
          {
            high = tmp;
          }
          else 
          {
            tmp.setNextNode(high);
            high.setPrevNode(tmp);
            high = tmp;
          }
        }
      }
      current = low;
      while (current.getNextNode().getInteger() < lastValue/2) 
      {
        current = current.getNextNode(); 
      }
      high.setPrevNode(current);
      current.setNextNode(high);
      low = sort(low, lastValue/2);
      high = sort(high, lastValue*3/4);
      return(low);
    }
  }
}
