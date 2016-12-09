public class BinaryTree 
{
  Node root;
  
  BinaryTree() 
  { 
    this.root = null;
  }
  
  public void insert(String newWord) 
  {
    Node newNode = new Node(newWord);
    this.insert(this.root, newNode); 
  }
  
  public void insert(Node subTree, Node newNode) 
  {
    if (newNode == null) 
    {
    }
    else if (this.root == null) 
    {
      this.root = newNode;
    }
    else if (newNode.word.compareTo(subTree.word) == 0) 
    {
      subTree.count++; 
    }
    else if (newNode.word.compareTo(subTree.word) < 0) 
    {
      if (subTree.leftNode == null) 
      {
        System.out.println("left " + newNode.word);
        subTree.leftNode = newNode;
        newNode.parent = subTree;
      }
      else 
      {
        System.out.println("left " + newNode.word);
        this.insert(subTree.leftNode, newNode);
      }
    }
    else 
    {
      if (subTree.rightNode == null) 
      {
        System.out.println("right " + newNode.word);
        subTree.rightNode = newNode;
        newNode.parent = subTree;
      }
      else 
      {
        System.out.println("right " + newNode.word);
        this.insert(subTree.rightNode, newNode);
      }
    }
  }
  
  public boolean isEmpty() 
  {
    return this.root == null;
  }
  
  public boolean deleteNode(String key) 
  {
    return(this.deleteNode(this.root, key));
  }
  
  public boolean deleteNode(Node subTree, String word) 
  {
    System.out.println("deleteNode: " + word);
    System.out.print("subTree: " + subTree.word);
    System.out.print(" key: " + word);
    System.out.println(" compareTo: " + word.compareTo(subTree.word));
    if (this.root == null) 
    {
      System.out.println("root == null");
      return(false);
    }
    else if (word.compareTo(subTree.word) == 0) 
    {
      this.insert(subTree.leftNode, subTree.rightNode);
      if (subTree == this.root) 
      {
        this.root = subTree.leftNode;
        this.root.parent = null;
      }
      else if (subTree.leftNode != null) 
      {
        subTree.leftNode.parent = subTree.parent;
        subTree.parent.leftNode = subTree.leftNode;
      } 
      else if (subTree.parent.leftNode != null && subTree.parent.leftNode.word.compareTo(word) == 0)
      {
        subTree.parent.leftNode = null;
      } 
      else if (subTree.parent.rightNode != null && subTree.parent.rightNode.word.compareTo(word) == 0) 
      {
        subTree.parent.rightNode = null;
      }
      return(true);
    }
    else if (word.compareTo(subTree.word) > 0) 
    {
      if (subTree.rightNode == null) 
      {
        return(false);
      }
      this.deleteNode(subTree.rightNode, word);
    }
    else 
    {
      if (subTree.leftNode == null) 
      {
        return(false);
      }
      this.deleteNode(subTree.leftNode, word);
    }
    return(false);
  }
  
  public void deleteTree() 
  {
    this.root = null;
  }
  
  public void print(int traverseType) 
  {
    switch (traverseType) 
    {
      case 1:
        this.printInOrder(this.root);
        break;
      case 2:
        this.printPreOrder(this.root);
        break;
      case 3:
        this.printPostOrder(this.root);
        break;
      default :
        this.printInOrder(this.root);
        break;
    }
    System.out.println("");
  }
  
  public void printPreOrder(Node subTree) 
  {
    if (subTree != null)
    {
      subTree.print();
      this.printPreOrder(subTree.leftNode);
      this.printPreOrder(subTree.rightNode);    
    }
  }
  
  public void printInOrder(Node subTree) 
  {
    if (subTree != null)
    {
      this.printInOrder(subTree.leftNode);
      subTree.print();
      this.printInOrder(subTree.rightNode);    
    }
  }
  
  public void printPostOrder(Node subTree) 
  {
    if (subTree != null)
    {
      this.printPostOrder(subTree.leftNode);
      this.printPostOrder(subTree.rightNode); 
      subTree.print();
    }
  }
  
    public int getSize(Node subTree) 
    {
    int size = 0;
    if (subTree != null)
    {
      size = this.getSize(subTree.leftNode);
      size ++;
      size = size + this.getSize(subTree.rightNode);    
    }
    return(size);
  }
  
    public void findMiddle(int index) //CHANGE BACK TO NODE CLASS & FIX!
    {
      for (int i = 0; i <= index; i++) 
      {
        /// traverse until we get to ith node
        // or something else?
      }
    }
    
    
  public void balance(Node subTree) //FIX CODE!
  {
    // find middle of subtree
    int size = getSize(subTree);
    // find middle index, accounting for truncation
    int middle = (int)(size/2+0.5);
    
    // make middle root
    // balance left
    // balance right
    
  }
}

class Node 
{
  public String word;
  public int count;
  public Node parent;
  public Node leftNode;
  public Node rightNode;

  Node(String word) 
  { 
    this.word = word; 
    this.count = 1;
    this.parent = null;
    this.leftNode = null;
    this.rightNode = null;
  }
  
  public void print() 
  {
    System.out.println(word + " count: " + this.count);
  }
}
