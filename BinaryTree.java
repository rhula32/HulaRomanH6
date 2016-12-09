public class BinaryTree 
{
  Node root;
  
  BinaryTree() 
  { 
    this.root = null;
  }
  
  public void insert(String newKey) 
  {
    Node newNode = new Node(newKey);
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
    else if (newNode.key.compareTo(subTree.key) == 0) 
    {
      subTree.count++; 
    }
    else if (newNode.key.compareTo(subTree.key) < 0) 
    {
      if (subTree.left == null) 
      {
        System.out.println("left " + newNode.key);
        subTree.left = newNode;
        newNode.parent = subTree;
      }
      else 
      {
        System.out.println("left " + newNode.key);
        this.insert(subTree.left, newNode);
      }
    }
    else 
    {
      if (subTree.right == null) 
      {
        System.out.println("right " + newNode.key);
        subTree.right = newNode;
        newNode.parent = subTree;
      }
      else 
      {
        System.out.println("right " + newNode.key);
        this.insert(subTree.right, newNode);
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
  
  public boolean deleteNode(Node subTree, String key) 
  {
    System.out.println("deleteNode: " + key);
    System.out.print("subTree: " + subTree.key);
    System.out.print(" key: " + key);
    System.out.println(" compareTo: " + key.compareTo(subTree.key));
    if (this.root == null) 
    {
      System.out.println("root == null");
      return(false);
    }
    else if (key.compareTo(subTree.key) == 0) 
    {
      this.insert(subTree.left, subTree.right);
      if (subTree == this.root) 
      {
        this.root = subTree.left;
        this.root.parent = null;
      }
      else if (subTree.left != null) 
      {
        subTree.left.parent = subTree.parent;
        subTree.parent.left = subTree.left;
      } 
      else if (subTree.parent.left != null && subTree.parent.left.key.compareTo(key) == 0)
      {
        subTree.parent.left = null;
      } 
      else if (subTree.parent.right != null && subTree.parent.right.key.compareTo(key) == 0) 
      {
        subTree.parent.right = null;
      }
      return(true);
    }
    else if (key.compareTo(subTree.key) > 0) 
    {
      if (subTree.right == null) return(false);
      this.deleteNode(subTree.right, key);
    }
    else 
    {
      if (subTree.left == null) return(false);
      this.deleteNode(subTree.left, key);
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
      this.printPreOrder(subTree.left);
      this.printPreOrder(subTree.right);    
    }
  }
  
  public void printInOrder(Node subTree) 
  {
    if (subTree != null)
    {
      this.printInOrder(subTree.left);
      subTree.print();
      this.printInOrder(subTree.right);    
    }
  }
  
  public void printPostOrder(Node subTree) 
  {
    if (subTree != null)
    {
      this.printPostOrder(subTree.left);
      this.printPostOrder(subTree.right); 
      subTree.print();
    }
  }
  
    public int getSize(Node subTree) 
    {
    int size = 0;
    if (subTree != null)
    {
      size = this.getSize(subTree.left);
      size ++;
      size = size + this.getSize(subTree.right);    
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
  public String key;
  public int count;
  public Node parent;
  public Node left;
  public Node right;

  Node(String key) 
  { 
    this.key = key; 
    this.count = 1;
    this.parent = null;
    this.left = null;
    this.right = null;
  }
  
  public void print() 
  {
    System.out.println(key + " count: " + this.count);
  }
}
